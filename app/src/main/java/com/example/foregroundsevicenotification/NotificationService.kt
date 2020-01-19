package com.example.foregroundsevicenotification

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class NotificationService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var text = intent?.getStringExtra("text")
        var notification = NotificationCompat.Builder(this,"ch1")
            .setContentTitle("Title1")
            .setContentText(text)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(PendingIntent.getActivity(this,0,Intent(this,MainActivity::class.java),0))
            .build()

        // if you don't call this method, this service must be killed, on MainActivity destroyee
        // so want to keep service alive even after MainActivity destroyee use this startForeground method.
        startForeground(1,notification)

        //stopSelf()
        return START_NOT_STICKY
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}