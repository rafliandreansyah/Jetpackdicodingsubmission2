package com.azhara.jetpackdicodingsubmission2.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesEntity (
    var id: String? = null,
    var title: String? = null,
    var release: String? = null,
    var vote_average: String? = null,
    var poster_path: String? = null,
    var backdrop_path: String? = null,
    var overview: String? = null
) : Parcelable
