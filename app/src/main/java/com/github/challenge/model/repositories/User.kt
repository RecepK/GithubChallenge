package com.github.challenge.model.repositories

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("company")
    val company: String,

    @SerializedName("blog")
    val blog: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("public_repos")
    val publicRepos: Int,

    @SerializedName("public_gists")
    val publicGists: Int,

    @SerializedName("followers")
    val followers: Int,

    @SerializedName("following")
    val following: Int
) : Parcelable
