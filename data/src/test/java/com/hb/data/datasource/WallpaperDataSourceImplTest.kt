package com.hb.data.datasource

import com.google.gson.Gson
import com.hb.data.helpers.fromJsonToObjectType
import com.hb.data.helpers.getJson
import com.hb.data.models.PhotosResponse
import com.hb.domain.usecase.GePhotosRequest

class WallpaperDataSourceImplTest : WallpaperDataSource {

    override suspend fun getPhotos(request: GePhotosRequest): List<PhotosResponse> {
        return Gson().fromJsonToObjectType(getJson("list_photos.json"))
    }

}