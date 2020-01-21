package com.example.foregroundsevicenotification

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_startService.setOnClickListener {
            startNService()
        }
        bt_stopService.setOnClickListener {
            stopNService()
        }


    }

    fun startNService() {
        var i = Intent(this, NotificationService::class.java)
        i.putExtra("text", et_text.text.toString())
        startService(i)
       // ContextCompat.startForegroundService(this, i)
    }

    fun stopNService(){
        var i = Intent(this, NotificationService::class.java)
        stopService(i)
    }
}
