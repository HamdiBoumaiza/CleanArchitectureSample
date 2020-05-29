package com.hb.domain.usecase

import com.hb.domain.common.GeneralUseCase
import com.hb.domain.entities.Photos
import com.hb.domain.repository.WallpaperRepository
import java.util.*

class GetListPhotosUseCase(
    private val wallpaperRepository: WallpaperRepository
) : GeneralUseCase<ArrayList<Photos>, GetListPhotosRequest> {

    override fun invoke(request : GetListPhotosRequest): ArrayList<Photos> = wallpaperRepository.getPhotos()

}

data class GetListPhotosRequest(
    val accessKey: String,
    val perPage: String,
    val pageNumber: Int,
    val orderBy: String
)