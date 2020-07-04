package com.hb.data.datasource

import com.hb.data.models.PhotosResponse
import com.hb.domain.usecase.GePhotosRequest


interface WallpaperDataSource {

    suspend fun getPhotos(request: GePhotosRequest): List<PhotosResponse>
}