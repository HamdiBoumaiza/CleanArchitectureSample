package com.hb.data.usecase

import com.hb.domain.repository.WallpaperRepository
import com.hb.domain.usecase.GePhotosRequest
import com.hb.domain.usecase.GetListPhotosUseCase

class GetPhotosUseCaseTest(private val wallpaperRepository: WallpaperRepository) :
    GetListPhotosUseCase(wallpaperRepository) {
    override suspend fun invoke(request: GePhotosRequest) =
        wallpaperRepository.getPhotos(request)
}