package com.hb.domain.repository

import com.hb.domain.entities.Photos
import java.util.*


interface WallpaperRepository {

    fun getPhotos(): ArrayList<Photos>

}