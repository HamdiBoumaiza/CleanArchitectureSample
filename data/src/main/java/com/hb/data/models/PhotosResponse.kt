package com.hb.data.models

import com.google.gson.annotations.SerializedName
import com.hb.data.commun.DomainMapper
import com.hb.domain.models.PhotoModel
import com.hb.domain.models.UrlModel

data class PhotosResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("urls") val urls: UrlsResponse?
) : DomainMapper<PhotoModel> {
    override fun mapToDomainModel() =
        PhotoModel(id ?: "", color ?: "", description ?: "", urls?.mapToDomainModel() ?: UrlModel())
}