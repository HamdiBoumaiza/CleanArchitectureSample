package com.hb.data.datasource

import com.hb.data.ApiService
import com.hb.data.commun.PHOTOS_PER_PAGE
import com.hb.data.commun.SECRET_KEY
import com.hb.data.models.PhotosResponse
import com.hb.domain.usecase.GePhotosRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WallpaperDataSourceImpl(private val api: ApiService) : WallpaperDataSource {

    override suspend fun getPhotos(request: GePhotosRequest): List<PhotosResponse> =
        withContext(Dispatchers.IO) {
            api.getPhotos(
                SECRET_KEY, PHOTOS_PER_PAGE, request.pageNumber, request.orderBy
            )
        }

}

