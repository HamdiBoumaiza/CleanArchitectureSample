package com.hb.cleanarchitecturesample.ui

import com.hb.domain.models.PhotoModel

interface PhotosClickListener {
    fun onPhotoItemClicked(photoModel: PhotoModel)
}