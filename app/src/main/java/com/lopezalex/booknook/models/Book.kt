package com.lopezalex.booknook.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(var name: String, var pages: String, var author: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable