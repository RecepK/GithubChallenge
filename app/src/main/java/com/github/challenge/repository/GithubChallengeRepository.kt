package com.github.challenge.repository

import com.github.challenge.remote.ClientInstance

class GithubChallengeRepository {

    suspend fun getSearchRepositories(query: String) =
        ClientInstance.apiService.getSearchRepositories(query, 100, 1)

    suspend fun getUserRepositories(user: String) =
        ClientInstance.apiService.getUserRepositories(user)

    suspend fun getUserProfile(user: String) = ClientInstance.apiService.getUserProfile(user)

}
