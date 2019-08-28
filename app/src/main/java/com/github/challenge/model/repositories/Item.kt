package com.github.challenge.model.repositories

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    @SerializedName("name")
    val name: String? = "",

    @SerializedName("full_name")
    val full_name: String?,

    @SerializedName("private")
    val private: Boolean?,

    @SerializedName("language")
    val language: String?,

    @SerializedName("description")
    val description: String? = "",

    @SerializedName("forks_count")
    val forksCount: Int?,

    @SerializedName("default_branch")
    val defaultBranch: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("owner")
    val owner: Owner
) : Parcelable
