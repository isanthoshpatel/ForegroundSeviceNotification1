package com.example.foregroundsevicenotification

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }


    @SuppressLint("NewApi")
    fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var ch1 = NotificationChannel("ch1", "ch1", NotificationManager.IMPORTANCE_DEFAULT)
            var nm = getSystemService(NotificationManager::class.java)
            nm.createNotificationChannel(ch1)

        }


    }

}