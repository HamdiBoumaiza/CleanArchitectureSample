package com.hb.cleanarchitecturesample

import android.app.Application
import com.facebook.stetho.Stetho
import com.hb.cleanarchitecturesample.di.component.AppComponent
import com.hb.cleanarchitecturesample.di.component.DaggerAppComponent
import com.hb.cleanarchitecturesample.di.module.AppModule
import timber.log.Timber

class WallpaperApplication : Application() {

    companion object {
        lateinit var appComponents: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initStetho()
        initTimber()
        initDI()
    }


    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initDI() {
        WallpaperApplication.appComponents = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}