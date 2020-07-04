package com.hb.domain.repository

import com.hb.domain.commun.WallpaperResult
import com.hb.domain.models.PhotoModel
import com.hb.domain.usecase.GePhotosRequest


interface WallpaperRepository {

    suspend fun getPhotos(request : GePhotosRequest): WallpaperResult<List<PhotoModel>>

}