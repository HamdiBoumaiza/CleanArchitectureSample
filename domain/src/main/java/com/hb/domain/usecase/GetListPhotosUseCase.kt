package com.hb.domain.usecase

import com.hb.domain.commun.GeneralUseCase
import com.hb.domain.commun.WallpaperResult
import com.hb.domain.models.PhotoModel
import com.hb.domain.repository.WallpaperRepository
import javax.inject.Inject

open class GetListPhotosUseCase @Inject constructor(
    private val wallpaperRepository: WallpaperRepository
) : GeneralUseCase<GePhotosRequest,WallpaperResult<List<PhotoModel>>> {
    override suspend fun invoke(request: GePhotosRequest) = wallpaperRepository.getPhotos(request)
}

data class GePhotosRequest(
    val pageNumber: Int,
    val orderBy: String
)