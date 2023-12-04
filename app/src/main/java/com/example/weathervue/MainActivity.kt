package com.example.weathervue

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.weathervue.data.remotedatasource.ApiClient
import com.example.weathervue.databinding.ActivityMainBinding
import com.example.weathervue.databinding.InitialSettingLayoutBinding
import com.example.weathervue.utils.APP_KEY
import com.example.weathervue.utils.LogUtil
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

const val TAG = "MainActivity"
const val InitialSettingSharedPref = "InitialSettingSharedPref"
const val MY_LOCATION_PERMISSION_ID = 5005
class MainActivity : AppCompatActivity() {

  lateinit var binding:ActivityMainBinding
  lateinit var fusedClient:FusedLocationProviderClient
  lateinit var locationCallback: LocationCallback

  lateinit var settingSharedPreferences: SharedPreferences
  lateinit var editor: Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        settingSharedPreferences  = getSharedPreferences(InitialSettingSharedPref, MODE_PRIVATE)
        editor = settingSharedPreferences.edit()


        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(""))
        val langTag = LocaleListCompat.forLanguageTags(Locale.getDefault().toLanguageTag())
        Log.i(TAG,"$langTag")

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(location: LocationResult) {
                super.onLocationResult(location)
                Log.i(TAG,"Current Location ${location.lastLocation}")

            }
        }
        

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


        binding.bottomNavBar.setOnItemSelectedListener {

            val itemId = it.itemId
            when(itemId){
                R.id.home -> navController.navigate(R.id.homeFragment)
                R.id.favourite -> navController.navigate(R.id.favouriteFragment)
                R.id.notification -> navController.navigate(R.id.alertFragment)
                R.id.setting ->navController.navigate(R.id.settingFragment)

            }
           true  //true means that I handled this function
        }


        lifecycleScope.launch {
            val response = ApiClient.apiClient.getWeather(APP_KEY, "33.44", "-94.04", "en")
            val current = response.body()?.current
            withContext(Dispatchers.Main){
            }
        }


    }


    override fun onStart() {
        super.onStart()

        val settingLocationValue = settingSharedPreferences.getInt(getString(R.string.mapkey), 0)
        Log.i(TAG,"shared pref setting  $settingLocationValue")
        if (settingLocationValue!=0){
            binding.navHostFragment.visibility = View.VISIBLE
            binding.bottomNavBar.visibility = View.VISIBLE
        }else {
            showInitSettingDialog(editor)
        }




    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
          if (requestCode == MY_LOCATION_PERMISSION_ID){
              if (grantResults[0]==PackageManager.PERMISSION_GRANTED || grantResults[1]==PackageManager.PERMISSION_GRANTED){
                 getLocation()
              }
          }
    }


    lateinit var alertDialog: AlertDialog

            private fun showInitSettingDialog(editor: Editor) {

                val materialAlertDialogBuilder = MaterialAlertDialogBuilder(this)
                val initDialogBinding:InitialSettingLayoutBinding = InitialSettingLayoutBinding.inflate(
                    LayoutInflater.from(this),null,false)

                 alertDialog = materialAlertDialogBuilder.setView(initDialogBinding.root)
                     .setTitle("Init Setup")
                     .setBackground(
                         ResourcesCompat.getDrawable(resources,R.drawable.dialog_background,theme)
                     )
                     .setCancelable(false).show()

                initDialogBinding.buttonSave.setOnClickListener{
                    val checkedRadioButtonId = initDialogBinding.locationInitGroup.checkedRadioButtonId

                    when(checkedRadioButtonId){
                        initDialogBinding.radioMap.id ->  {
                            LogUtil.shouToastMsg(this,"From Map")
                            editor.putInt(getString(R.string.mapkey),initDialogBinding.radioMap.id)
                        }
                        initDialogBinding.radioGps.id ->  {
                            LogUtil.shouToastMsg(this,"From GPS")
                            getLocation()
                            editor.putInt(getString(R.string.mapkey),initDialogBinding.radioGps.id)

                        }
                    }
                    editor.commit()

                    alertDialog.dismiss()

                }

            }

    private fun getLocation() {
        binding.navHostFragment.visibility = View.INVISIBLE
        binding.bottomNavBar.visibility = View.INVISIBLE
         if (isGpsAndNetworkPermissionsGranted()){

             if(isLocationEnabled()){
                 requestNewLocationData()
             }else{
                 val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                 startActivity(intent)

             }


         }else{
             LogUtil.shouToastMsg(this,"Kindly Location Permission required for app usage")
             requestLocationPermission()
         }
    }

    private fun isGpsAndNetworkPermissionsGranted():Boolean{
          val result = ActivityCompat.checkSelfPermission(this,
               Manifest.permission.ACCESS_FINE_LOCATION
              ) == PackageManager.PERMISSION_GRANTED ||
                  ActivityCompat.checkSelfPermission(this,
                  Manifest.permission.ACCESS_COARSE_LOCATION)  == PackageManager.PERMISSION_GRANTED

              return result;
    }
    private fun requestLocationPermission(){
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),
                 MY_LOCATION_PERMISSION_ID
        )
    }

    private fun isLocationEnabled():Boolean{
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }
    @SuppressLint("MissingPermission")
    private fun requestNewLocationData(){
        val locationRequest = LocationRequest.create().apply {
            interval = 0
            fastestInterval = 500
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        fusedClient = LocationServices.getFusedLocationProviderClient(this)
        fusedClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper())
        binding.navHostFragment.visibility = View.VISIBLE
        binding.bottomNavBar.visibility = View.VISIBLE
    }
}

//        val langTag = LocaleListCompat.forLanguageTags(Locale.getDefault().toLanguageTag())
//        AppCompatDelegate.setApplicationLocales(langTag)
//        val lang = AppCompatDelegate.getApplicationLocales().toLanguageTags()
//
//
//val sharedPreferences = getSharedPreferences("Setting_Shared_Pref", MODE_PRIVATE)
//        val editor : SharedPreferences.Editor =  sharedPreferences.edit()
//        editor.putString("LOG_IN","logged").apply()
//        val preferences = getSharedPreferences("Setting_Shared_Pref", MODE_PRIVATE)
//        val str = preferences.getString("LOG_IN", "Null")


//        if (lang.isBlank()){
//             val lanTag = LocaleListCompat.forLanguageTags(Locale.getDefault().toLanguageTag())
//             AppCompatDelegate.setApplicationLocales(lanTag)
//         }else{
//
//         }


