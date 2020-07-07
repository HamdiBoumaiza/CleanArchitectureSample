package com.hb.cleanarchitecturesample.ui

import androidx.lifecycle.Observer
import com.hb.cleanarchitecturesample.R
import com.hb.cleanarchitecturesample.WallpaperApplication
import com.hb.cleanarchitecturesample.baseui.BaseViewModelActivity
import com.hb.cleanarchitecturesample.commun.toast
import com.hb.domain.models.PhotoModel
import com.hb.domain.usecase.GePhotosRequest
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity :
    BaseViewModelActivity<MainActivityViewModel>(MainActivityViewModel::class.java),
    PhotosClickListener {

    override val layoutResId: Int = R.layout.activity_main

    override fun initViews() {
        viewModel.getPhotos(GePhotosRequest(1, "latest"))
    }

    override fun inject() {
        WallpaperApplication.appComponents.inject(this)
    }

    override fun initObservers() {
        viewModel.resultUser.observe(this, Observer(::initRecyclerPhotos))
        viewModel.resultError.observe(this, Observer {
            Timber.e("error $it")
        })
    }

    private fun initRecyclerPhotos(listPhotos: List<PhotoModel>) {
        rv_photos.adapter = PhotosAdapter(this, listPhotos)
    }

    override fun onPhotoItemClicked(photoModel: PhotoModel) {
        toast("clicked")
    }
}