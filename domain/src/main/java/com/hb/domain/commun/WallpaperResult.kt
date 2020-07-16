package com.hb.domain.commun

sealed class WallpaperResult<out T> {
    data class Success<out T>(val data: T) : WallpaperResult<T>()
    data class Error<T>(val exception: WallpaperResultException) : WallpaperResult<T>()
}

inline fun <T : Any> WallpaperResult<T>.onSuccess(action: (T) -> Unit): WallpaperResult<T> {
    if (this is WallpaperResult.Success) action(data)
    return this
}

inline fun <T : Any> WallpaperResult<T>.onError(action: (WallpaperResultException) -> Unit): WallpaperResult<T> {
    if (this is WallpaperResult.Error) action(exception)
    return this
}
