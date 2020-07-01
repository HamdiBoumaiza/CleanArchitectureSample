package com.hb.data.commun

import com.hb.domain.commun.WallpaperResult


suspend fun <T> tryResult(call: suspend () -> T): WallpaperResult<T> {
    return try {
        WallpaperResult.Success(data = call())
    } catch (e: Exception) {
        WallpaperResult.Error(RequestErrorHandler().getRequestError(e))
    }
}

