package com.hb.data.entities

import com.google.gson.annotations.SerializedName
import com.hb.domain.models.Photos
import com.hb.domain.models.Urls
import com.hb.data.commun.DomainMapper

data class PhotosResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("urls") val urls: Urls?
): DomainMapper<Photos> {
    override fun mapToDomainModel() = Photos(id, color,description,urls)
}