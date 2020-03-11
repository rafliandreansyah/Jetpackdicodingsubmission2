package com.azhara.jetpackdicodingsubmission2.data.source.remote

import android.util.Log
import com.azhara.jetpackdicodingsubmission2.data.source.remote.response.MoviesResponse
import com.azhara.jetpackdicodingsubmission2.data.source.remote.response.TvShowResponse
import com.azhara.jetpackdicodingsubmission2.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovies(): List<MoviesResponse> {
        val movie = jsonHelper.loadMovies()
        Log.d("RemoteDataSource", "$movie")
        return movie
    }

    fun getAllTvShow(): List<TvShowResponse> = jsonHelper.loadTvShow()

}