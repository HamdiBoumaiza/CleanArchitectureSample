package com.hb.data.repository


import com.hb.data.commun.tryResult
import com.hb.data.datasource.WallpaperDataSource
import com.hb.domain.commun.WallpaperResult
import com.hb.domain.models.Photos
import com.hb.domain.repository.WallpaperRepository
import com.hb.domain.usecase.GePhotosRequest
import java.util.*

class WallpaperRepositoryImpl(private val wallpaperDataSource: WallpaperDataSource) :
    WallpaperRepository {
    override suspend fun getPhotos(request: GePhotosRequest): WallpaperResult<List<Photos>> {
        return when (val result = tryResult { wallpaperDataSource.getPhotos(request) }) {
            is WallpaperResult.Success -> {
                WallpaperResult.Success(result.data.map { photos ->
                    photos.mapToDomainModel()
                })
            }
            is WallpaperResult.Error -> {
                WallpaperResult.Error(result.exception)
            }
        }
    }

}
