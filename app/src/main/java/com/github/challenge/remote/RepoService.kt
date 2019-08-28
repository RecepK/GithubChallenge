package com.github.challenge.remote

import com.github.challenge.model.repositories.Item
import com.github.challenge.model.repositories.Repository
import com.github.challenge.model.repositories.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoService {

    @GET("search/repositories")
    suspend fun getSearchRepositories(
        @Query("q") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Repository

    @GET("users/{user}")
    suspend fun getUserProfile(@Path("user") user: String): User

    @GET("users/{user}/repos")
    suspend fun getUserRepositories(@Path("user") user: String): List<Item>
}
