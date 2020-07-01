package com.hb.cleanarchitecturesample.ui

import androidx.lifecycle.Observer
import com.hb.cleanarchitecturesample.R
import com.hb.cleanarchitecturesample.WallpaperApplication
import com.hb.cleanarchitecturesample.baseui.BaseViewModelActivity

class MainActivity :
    BaseViewModelActivity<MainActivityViewModel>(MainActivityViewModel::class.java) {

    override val layoutResId: Int = R.layout.activity_main

    override fun initViews() {
        WallpaperApplication.appComponents.inject(this)
        viewModel.getUser(params)
    }

    override fun initObservers() {
        viewModel.resultUser.observe(this, Observer {
            tv_main_test.text = it.name
        })
        viewModel.resultError.observe(this, Observer {
            tv_main_test.text = it.toString()
        })
    }

}