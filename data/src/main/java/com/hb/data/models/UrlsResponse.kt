package com.hb.data.models

import com.google.gson.annotations.SerializedName
import com.hb.domain.models.UrlModel
import com.hb.data.commun.DomainMapper


data class UrlsResponse(
    @SerializedName("raw") val raw: String? = null,
    @SerializedName("full") val full: String? = null,
    @SerializedName("regular") val regular: String? = null,
    @SerializedName("small") val small: String? = null,
    @SerializedName("thumb") val thumb: String? = null
) : DomainMapper<UrlModel> {
    override fun mapToDomainModel() = UrlModel(raw?:"", full?:"", regular?:"", small?:"", thumb?:"")
}