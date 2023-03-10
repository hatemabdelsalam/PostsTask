package com.hatem.stctask.network

import com.hatem.stctask.shared.model.PhotosModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Urls.photos)
    suspend fun getPhotos(
        @Query("_start") start: Int,
        @Query("_limit") limit: Int
    ): List<PhotosModel>

}