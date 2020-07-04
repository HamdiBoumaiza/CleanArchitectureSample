package com.hb.data.commun

import com.hb.data.R
import com.hb.domain.commun.WoqodeResultException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

private const val HTTP_CODE_CLIENT_START = 400
private const val HTTP_CODE_CLIENT_END = 499
private const val HTTP_CODE_SERVER_START = 500
private const val HTTP_CODE_SERVER_END = 599

object RequestErrorHandler {

    fun getRequestError(throwable: Throwable): WoqodeResultException {
        return when (throwable) {
            is HttpException -> {
                handleHttpException(throwable)
            }
            is IOException -> {
                WoqodeResultException.Connection(R.string.error_unexpected_message)
            }
            is SocketTimeoutException -> {
                WoqodeResultException.Timeout(R.string.error_unexpected_message)
            }
            else -> {
                WoqodeResultException.Unexpected(R.string.error_unexpected_message)
            }
        }
    }

    private fun handleHttpException(httpException: HttpException): WoqodeResultException {
        return when (httpException.code()) {
            in HTTP_CODE_CLIENT_START..HTTP_CODE_CLIENT_END -> {
                WoqodeResultException.Client(R.string.error_unexpected_message)
            }
            in HTTP_CODE_SERVER_START..HTTP_CODE_SERVER_END -> {
                WoqodeResultException.Server(R.string.error_unexpected_message)
            }
            else -> {
                WoqodeResultException.Unexpected(R.string.error_unexpected_message)
            }
        }
    }

}