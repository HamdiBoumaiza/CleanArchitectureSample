package com.hb.domain.repository

import com.hb.domain.commun.WallpaperResult
import com.hb.domain.models.Photos
import com.hb.domain.usecase.GePhotosRequest
import java.util.*


interface WallpaperRepository {

    suspend fun getPhotos(request : GePhotosRequest): WallpaperResult<List<Photos>>

}