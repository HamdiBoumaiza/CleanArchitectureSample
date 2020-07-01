package com.hb.data.datasource

import com.hb.data.ApiService
import com.hb.data.entities.PhotosResponse
import com.hb.domain.usecase.GePhotosRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WallpaperDataSourceImpl(private val api: ApiService) : WallpaperDataSource {

    override suspend fun getPhotos(request: GePhotosRequest): List<PhotosResponse> =
        withContext(Dispatchers.IO) {
            api.getPhotos(
                request.accessKey, request.perPage, request.pageNumber, request.orderBy
            )
        }

}

