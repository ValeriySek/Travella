package com.app.travella.android

import retrofit2.Response
import retrofit2.http.GET

interface MainService {

    @GET("places/")
    suspend fun getData(): Response<Test>
}