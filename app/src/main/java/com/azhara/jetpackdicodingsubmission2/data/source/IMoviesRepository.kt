package com.azhara.jetpackdicodingsubmission2.data.source

import androidx.lifecycle.LiveData
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.MoviesEntity
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.TvShowEntity

interface IMoviesRepository {

    fun getAllMovies(): LiveData<List<MoviesEntity>>

    fun getAllTvShow(): LiveData<List<TvShowEntity>>

}