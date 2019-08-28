package com.github.challenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.challenge.model.repositories.Item
import com.github.challenge.model.repositories.Repository
import com.github.challenge.model.repositories.User
import com.github.challenge.repository.GithubChallengeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val challengeRepository = GithubChallengeRepository()


    /**
     * Search Repositories
     */
    val repository = MutableLiveData<Repository>()

    fun getSearchRepositories(query: String) {
        viewModelScope.launch {
            val repo: Repository = challengeRepository.getSearchRepositories(query)

            withContext(Dispatchers.Main) {
                repository.value = repo
            }
        }
    }


    /**
     * User Repositories
     */
    val repoList = MutableLiveData<List<Item>>()

    fun getUserRepositories(user: String) {
        viewModelScope.launch {
            val repos: List<Item> = challengeRepository.getUserRepositories(user)

            withContext(Dispatchers.Main) {
                repoList.value = repos
            }
        }
    }


    /**
     * User Profile
     */
    val profile = MutableLiveData<User>()

    fun getUserProfile(user: String) {
        viewModelScope.launch {
            val profileData: User = challengeRepository.getUserProfile(user)

            withContext(Dispatchers.Main) {
                profile.value = profileData
            }
        }
    }
}
