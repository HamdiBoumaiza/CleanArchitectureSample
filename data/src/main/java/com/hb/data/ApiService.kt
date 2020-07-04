package com.hb.data

import com.hb.data.models.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("photos/")
    suspend fun getPhotos(
        @Query("client_id") access_key: String?,
        @Query("per_page") per_page: String?,
        @Query("page") page: Int,
        @Query("order_by") order_by: String?
    ): ArrayList<PhotosResponse>
}