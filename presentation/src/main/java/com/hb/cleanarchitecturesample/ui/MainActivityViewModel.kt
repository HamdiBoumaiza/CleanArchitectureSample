package com.hb.cleanarchitecturesample.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hb.cleanarchitecturesample.baseui.BaseViewModel
import com.hb.domain.commun.onError
import com.hb.domain.commun.onSuccess
import com.hb.domain.models.PhotoModel
import com.hb.domain.usecase.GePhotosRequest
import com.hb.domain.usecase.GetListPhotosUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val getListPhotosUseCase: GetListPhotosUseCase) :
    BaseViewModel() {

    private val _resultUser = MutableLiveData<List<PhotoModel>>()
    val resultUser: LiveData<List<PhotoModel>> = _resultUser

    private val _resultError = MutableLiveData<Int>()
    val resultError: LiveData<Int> = _resultError

    fun getPhotos(request : GePhotosRequest) {
        viewModelScope.launch {
            showLoadingToggle(true)
            getListPhotosUseCase(request)
                .onSuccess {
                    showLoadingToggle(false)
                    _resultUser.postValue(it)
                }
                .onError {
                    showLoadingToggle(false)
                    _resultError.postValue(it.messageResource)
                }
        }
    }
}