package com.hb.domain.models

import java.io.Serializable


data class PhotoModel(
    val id: String,
    val color: String,
    val description: String,
    val urls: UrlModel
) : Serializable