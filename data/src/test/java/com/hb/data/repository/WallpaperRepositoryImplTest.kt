package com.hb.data.repository

import com.hb.data.commun.tryResult
import com.hb.data.datasource.WallpaperDataSourceImplTest
import com.hb.domain.commun.WallpaperResult
import com.hb.domain.models.PhotoModel
import com.hb.domain.repository.WallpaperRepository
import com.hb.domain.usecase.GePhotosRequest

class WallpaperRepositoryImplTest(private val wallpaperDataSourceImplTest: WallpaperDataSourceImplTest) :
    WallpaperRepository {

    override suspend fun getPhotos(request: GePhotosRequest): WallpaperResult<List<PhotoModel>> {
        return when (val result = tryResult { wallpaperDataSourceImplTest.getPhotos(request) }) {
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