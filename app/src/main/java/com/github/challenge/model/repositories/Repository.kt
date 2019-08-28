package com.github.challenge.model.repositories

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    @SerializedName("total_count")
    val totalCount: Int? = 0,

    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = false,

    @SerializedName("items")
    val items: List<Item>? = null
) : Parcelable
