package com.hb.cleanarchitecturesample.baseui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hb.cleanarchitecturesample.commun.AppRouter

abstract class BaseViewModel : ViewModel() {

    lateinit var appRouter: AppRouter

    private val _toggleLoading = MutableLiveData<Boolean>()
    val toggleLoading: LiveData<Boolean> = _toggleLoading

    open fun onPause() {
        _toggleLoading.value = false
    }

    protected fun showLoadingToggle(visible: Boolean) = _toggleLoading.postValue(visible)

}