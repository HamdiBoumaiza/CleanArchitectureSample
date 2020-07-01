package com.hb.cleanarchitecturesample.baseui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.hb.cleanarchitecturesample.commun.viewModelProvider
import com.hb.cleanarchitecturesample.di.viewmodels.DaggerViewModelFactory
import javax.inject.Inject

abstract class BaseViewModelFragment<VM : BaseViewModel>(private val modelClass: Class<VM>) :
    BaseFragment() {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initViews()
        initLoadingToggle()
        viewModel.appRouter = appRouter
    }

    abstract fun initObservers()

    private fun initLoadingToggle() {
        viewModel.toggleLoading.observe(viewLifecycleOwner, Observer { toggleLoading(it!!) })
    }

    protected val viewModel: VM by lazy {
        viewModelProvider(
            this.viewModelFactory,
            modelClass.kotlin
        )
    }

}