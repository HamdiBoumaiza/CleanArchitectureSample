package com.hb.cleanarchitecturesample.baseui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.hb.cleanarchitecturesample.commun.viewModelProvider
import com.hb.cleanarchitecturesample.di.viewmodels.DaggerViewModelFactory
import javax.inject.Inject

abstract class BaseViewModelActivity<VM : BaseViewModel>(private val modelClass: Class<VM>) :
    BaseActivity() {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
        initLoadingToggle()
        initViews()
        viewModel.appRouter = appRouter
    }

    abstract fun initObservers()

    private fun initLoadingToggle() {
        viewModel.toggleLoading.observe(this, Observer { toggleLoading(it!!) })
    }


    protected val viewModel: VM by lazy {
        viewModelProvider(
            viewModelFactory,
            modelClass.kotlin
        )
    }

}