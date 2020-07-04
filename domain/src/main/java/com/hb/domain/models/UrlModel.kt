package com.hb.domain.models

import java.io.Serializable


data class UrlModel(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
): Serializable {
    constructor() : this("", "", "", "", "")
}