package com.hb.cleanarchitecturesample

import android.app.Application
import com.facebook.stetho.Stetho
import timber.log.Timber

class WallpaperApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initStetho()
        initTimber()
    }


    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}