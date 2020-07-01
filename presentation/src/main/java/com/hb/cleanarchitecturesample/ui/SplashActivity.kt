package com.hb.cleanarchitecturesample.ui

import android.os.Handler
import com.hb.cleanarchitecturesample.R
import com.hb.cleanarchitecturesample.baseui.BaseActivity

class SplashActivity : BaseActivity() {

    override val layoutResId: Int = R.layout.activity_splash

    override fun initViews() {
        goToHomeScreen()
    }

    private fun goToHomeScreen() {
        Handler().postDelayed({
            appRouter.goToActivity(MainActivity::class.java, true)
        }, 2000)
    }
}