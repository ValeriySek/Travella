package com.app.travella.android

import android.util.Log
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    val mainService: MainService
) {

    suspend fun getData(): Response<Test> {

        Log.i("TAGGG", "MainRepository getData")
        return mainService.getData()
    }
}