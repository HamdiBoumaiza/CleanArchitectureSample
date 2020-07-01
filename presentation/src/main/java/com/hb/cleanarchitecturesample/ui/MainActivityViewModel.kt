package com.hb.cleanarchitecturesample.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.proxym.domain.commun.onError
import com.proxym.domain.commun.onSuccess
import com.proxym.domain.models.User
import com.proxym.domain.usecases.GetUserUseCase
import com.hb.cleanarchitecturesample.baseui.BaseViewModel
import com.hb.domain.models.Photos
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase) :
    BaseViewModel() {

    private val _resultUser = MutableLiveData<Photos>()
    val resultUser: LiveData<Photos> = _resultUser

    private val _resultError = MutableLiveData<Any>()
    val resultError: LiveData<Any> = _resultError

    fun getPhotos(params: HashMap<String, String>) {
        viewModelScope.launch {
            showLoadingToggle(true)
            getUserUseCase(params)
                .onSuccess {
                    showLoadingToggle(false)
                    _resultUser.postValue(it)
                }
                .onError {
                    showLoadingToggle(false)
                    _resultError.postValue(it.errorMessage)
                }
        }
    }
}