package com.github.challenge.model.user

import com.github.challenge.model.repositories.Item
import com.github.challenge.model.repositories.User

data class UserDetailModel(
    val user: User?,
    val repositories: Item?
)
