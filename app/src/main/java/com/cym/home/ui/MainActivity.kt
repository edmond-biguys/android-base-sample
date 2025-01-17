package com.cym.home.ui

import android.Manifest
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.media.AudioManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cym.base.BaseActivity
import com.cym.sample.binder.RemoteService
import com.cym.utilities.logi
import com.githang.statusbar.StatusBarCompat
import com.xmcc.androidbasesample.R
import com.xmcc.androidbasesample.databinding.ActivityMain2Binding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logi("MainActivity onCreate")
        StatusBarCompat.setStatusBarColor(this, resources.getColor(R.color.light_blue_A401))
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val cameraManager: CameraManager
        val activityManager: ActivityManager
        val wifiManager: WifiManager
        val audioManager: AudioManager
        val displayManager: DisplayManager

        //badge（通知数量小红点 或者 数字）使用
        val badgeHome = binding.bottomNavigationViewHome.getOrCreateBadge(R.id.navigation_home)
        val badgeTrip = binding.bottomNavigationViewHome.getOrCreateBadge(R.id.navigation_trip)
        badgeTrip.number = 999
        badgeTrip.maxCharacterCount = 3
        badgeTrip.backgroundColor = Color.parseColor("#ffe36451")
        val badge = binding.bottomNavigationViewHome.getOrCreateBadge(R.id.navigation_user)

        /*
        把navigation和bottomNavigationView做绑定
        navigation graph中，对应fragment的id 和 bottomNavigationView中menu的id需要一样。
         */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.homeFragmentContainerView) as NavHostFragment
        binding.bottomNavigationViewHome.setupWithNavController(navHostFragment.findNavController())


        checkPermission()

        val bug01 = Bug01()
        bug01.bug01()

        val componentName = startService(Intent(this, RemoteService::class.java))
        Log.i("MainActivity", "onCreate: componentName $componentName")

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //sendBroadcast(Intent())
        //bindService()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        logi("result code $resultCode")
        data?.let {
            val abc = data.getIntExtra("abc", -1)
            logi("abc $abc")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        logi("MainActivity onDestroy")
    }

    private fun checkPermission() {
        val granted = ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (granted != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0x0011
            )
        }
    }
}