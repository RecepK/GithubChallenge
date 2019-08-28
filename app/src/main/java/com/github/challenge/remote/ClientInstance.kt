package com.github.challenge.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientInstance {

    private const val BASE_URL = "https://api.github.com/"

    var apiService: RepoService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(RepoService::class.java)
    }
}
