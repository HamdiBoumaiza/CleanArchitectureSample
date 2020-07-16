package com.hb.cleanarchitecturesample.baseui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hb.cleanarchitecturesample.R
import com.hb.cleanarchitecturesample.WallpaperApplication
import com.hb.cleanarchitecturesample.commun.AppRouter
import com.hb.cleanarchitecturesample.commun.AppSharedPreferences
import com.hb.cleanarchitecturesample.commun.toast
import com.hb.cleanarchitecturesample.utils.ConnectionLiveData


abstract class BaseActivity : AppCompatActivity() {

    lateinit var appRouter: AppRouter
    val sharedPreferences: AppSharedPreferences by lazy { WallpaperApplication.appComponents.appSharedPref() }

    private lateinit var container: ViewGroup
    private lateinit var loading: View

    abstract val layoutResId: Int
    abstract fun initViews()
    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        appRouter = AppRouter(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        checkInternetAvailability()
        initLoading()
        inject()
        initViews()
    }

    private fun checkInternetAvailability() {
        ConnectionLiveData(this).observe(this, Observer {
            if (!it) {
                toast(getString(R.string.CommonErrorNetwork))
            }
        })
    }

    private fun initLoading() {
        container = findViewById<View>(android.R.id.content) as ViewGroup
        loading = LayoutInflater.from(this).inflate(R.layout.layout_loading, container, false)
        loading.setOnTouchListener { _, _ -> true }
    }

    fun toggleLoading(show: Boolean) {
        synchronized(WallpaperApplication.appComponents) {
            if (!isDestroyed) {
                container.removeView(loading)
                if (show) {
                    container.addView(loading)
                }
            }
        }
    }

}