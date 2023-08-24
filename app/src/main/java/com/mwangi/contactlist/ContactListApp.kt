package com.mwangi.contactlist

import android.app.Application
import android.content.Context

class ContactListApp: Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}