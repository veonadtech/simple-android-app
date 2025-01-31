package com.example.weatherapp

import android.Manifest
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.FragmentHomeBinding
import java.util.*

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.weatherapp.fragment.HomeFragment
import com.example.weatherapp.fragment.VirtualFragment
import com.example.weatherapp.model.Main
import com.google.android.gms.location.*
import org.prebid.mobile.AdSize
import org.prebid.mobile.Host
import org.prebid.mobile.PrebidMobile
import org.prebid.mobile.api.data.InitializationStatus
import org.prebid.mobile.api.exceptions.AdException
import org.prebid.mobile.api.rendering.BannerView
import org.prebid.mobile.api.rendering.listeners.BannerViewListener
import org.prebid.mobile.eventhandlers.AuctionBannerEventHandler
import org.prebid.mobile.eventhandlers.AuctionListener


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val homeFragment = HomeFragment()

    var permissions = 0

    //    Declaring the needed Variables
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest
    private val PERMISSION_ID = 21

    private fun initBanglaPrebidSDK() {
        Log.d("Debug:", "SDK start initialization")

        PrebidMobile.setPrebidServerAccountId("com.arena.banglalinkmela.app")
        PrebidMobile.setPrebidServerHost(Host.createCustomHost("https://prebid.bangladsp.com/openrtb2/auction"))
        PrebidMobile.setCustomStatusEndpoint("https://prebid.bangladsp.com/status")
        PrebidMobile.setTimeoutMillis(100000)
        PrebidMobile.setShareGeoLocation(true)

        PrebidMobile.initializeSdk(applicationContext) { status ->
            if (status == InitializationStatus.SUCCEEDED) {
                Log.d("Debug:", "SDK initialized successfully!")
            } else {
                Log.e("Debug:", "SDK initialization error: $status\n${status.description}")
            }
        }
    }

    private fun showAds() {
        // listener for wrapping GAM rendering
        val eventHandler = AuctionBannerEventHandler(
            this,
            "/6355419/Travel/Europe/France/Paris",
            0.1F,
            AdSize(320, 50)
        )

        // lister for understand where from demand
        eventHandler.setAuctionEventListener(object : AuctionListener {
            override fun onPRBWin(price: Float) {
                Toast.makeText(applicationContext, "onPRBWin", Toast.LENGTH_LONG).show()
            }
            override fun onGAMWin(view: View?) {
                Toast.makeText(applicationContext, "onGAMWin", Toast.LENGTH_LONG).show()
            }
        })

        // configure banner placement
        val adUnit = BannerView(this, "prebid-ita-banner-320-50", eventHandler)

        // lister for custom tracking or custom display creative
        adUnit.setBannerListener(object : BannerViewListener {
            override fun onAdUrlClicked(url: String?) {
                Toast.makeText(applicationContext, url, Toast.LENGTH_LONG).show()
            }
            override fun onAdLoaded(bannerView: BannerView?) {
                Toast.makeText(applicationContext, "onAdLoaded", Toast.LENGTH_LONG).show()
            }
            override fun onAdDisplayed(bannerView: BannerView?) {
                Toast.makeText(applicationContext, "onAdDisplayed", Toast.LENGTH_LONG).show()
            }

            override fun onAdFailed(bannerView: BannerView?, exception: AdException?) {
                Toast.makeText(applicationContext, "onAdFailed", Toast.LENGTH_LONG).show()
            }

            override fun onAdClicked(bannerView: BannerView?) {
                Toast.makeText(applicationContext, "onAdClicked", Toast.LENGTH_LONG).show()
            }

            override fun onAdClosed(bannerView: BannerView?) {
                Toast.makeText(applicationContext, "onAdClosed", Toast.LENGTH_LONG).show()
            }
        })

        val AdSlot = binding.ads
        AdSlot.addView(adUnit)
        adUnit.loadAd()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        virtualFragment.hideNextBtn()

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        RequestPermission()
        getLastLocation()
        initBanglaPrebidSDK()
        showAds()
        Log.i("MainActivity", "it catch here")
        Log.d("Debug:", "permission " + checkPermission().toString())
        Log.d("Debug:", "location is enable " + isLocationEnabled().toString())
    }


    fun getLastLocation() {
        if (checkPermission()) {
            if (isLocationEnabled()) {
                fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
                    var location: Location? = task.result
                    if (location == null) {
                        NewLocationData()
                        Log.d("Debug", "location null")
                    } else {
                        Log.d(
                            "Debug:",
                            "Your Location: Longtitude: " + location.longitude + "Latitude: " + location.latitude
                        )
                        LATITUDE = location.latitude
                        LONGITUDE = location.longitude
//                        virtualFragment.displayNextBtn()
                        loadFragment(homeFragment)
                    }
                }

            } else {
                Toast.makeText(this, "Please Turn on Your device Location", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            RequestPermission()
        }
    }


    fun NewLocationData() {
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 0
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 1
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        checkPermission()
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest, locationCallback, Looper.myLooper()
        )
    }


    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var lastLocation: Location = locationResult.lastLocation
            LATITUDE = lastLocation.latitude
            LONGITUDE = lastLocation.longitude
            Log.d("Debug:", "your last last location: " + lastLocation.longitude.toString())
        }
    }

    fun checkPermission(): Boolean {
        //this function will return a boolean
        //true: if we have permission
        //false if not
        if (
            ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }

        return false

    }
    public fun loadFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .addToBackStack(null)
            .commit()
    }

    fun RequestPermission() {
        //this function will allows us to tell the user to requesut the necessary permsiion if they are not garented
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                PERMISSION_ID
            )
        }
    }

    fun isLocationEnabled(): Boolean {
        //this function will return to us the state of the location service
        //if the gps or the network provider is enabled then it will return true otherwise it will return false
        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_ID) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Log.d("Debug:", "You have the Permission")
                getLastLocation()
            }
        }
        else
            setPermission()
    }

    private fun setPermission(){
        permissions = 1
    }

    fun removeFragment(fragment: Fragment){
        val manager : FragmentManager = this.supportFragmentManager
        val fragTransaction : FragmentTransaction = manager.beginTransaction()
        fragTransaction.remove(fragment)
        fragTransaction.commit()
        manager.popBackStack()
    }
}