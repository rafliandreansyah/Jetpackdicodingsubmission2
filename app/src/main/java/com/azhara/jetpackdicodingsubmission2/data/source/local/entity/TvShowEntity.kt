package com.azhara.jetpackdicodingsubmission2.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowEntity(
    var id: String? = null,
    var name: String? = null,
    var first_air_date: String? = null,
    var vote_average: String? = null,
    var poster_path: String? = null,
    var backdrop_path: String? = null,
    var overview: String? = null
) : Parcelable