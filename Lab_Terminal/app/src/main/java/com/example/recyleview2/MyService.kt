package com.example.services

import android.app.Service
import android.content.Intent
import android.nfc.Tag
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    val TAG ="MyService"

    override fun onBind(intent: Intent): IBinder?=null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val datastring= intent?.getStringExtra("ExtraData")
        datastring?.let{
            Log.d(TAG,datastring)
        }
        Thread{
            while (true){}
        }.start()
        Log.d(TAG,"Service has been Running")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service has been Killed")
    }
}