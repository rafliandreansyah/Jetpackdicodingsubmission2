package com.azhara.jetpackdicodingsubmission2.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.MoviesEntity
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.TvShowEntity
import com.azhara.jetpackdicodingsubmission2.data.source.remote.RemoteDataSource

class MoviesRepository private constructor(private val remoteDataSource: RemoteDataSource): IMoviesRepository{

    companion object{
        @Volatile
        private var instance: MoviesRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MoviesRepository =
            instance ?: synchronized(this){
                instance ?: MoviesRepository(remoteDataSource)
            }
    }

    override fun getAllMovies(): LiveData<List<MoviesEntity>> {
        val moviesResponse = remoteDataSource.getAllMovies()
        val moviesResult = MutableLiveData<List<MoviesEntity>>()
        val listMovies = ArrayList<MoviesEntity>()
        for (response in moviesResponse){
            val movies = MoviesEntity(
                response.id,
                response.title,
                response.release,
                response.vote_average,
                response.poster_path,
                response.backdrop_path,
                response.overview
            )
            listMovies.add(movies)
        }
        Log.d("MovieRepomovie", "$moviesResponse")
        moviesResult.postValue(listMovies)
        return moviesResult
    }

    override fun getAllTvShow(): LiveData<List<TvShowEntity>> {
        val tvShowResponse = remoteDataSource.getAllTvShow()
        val tvShowResult = MutableLiveData<List<TvShowEntity>>()
        val listTvShow = ArrayList<TvShowEntity>()
        for (response in tvShowResponse){
            val tvShow = TvShowEntity(
                response.id, response.title,
                response.release,
                response.vote_average,
                response.poster_path,
                response.backdrop_path,
                response.overview)
            listTvShow.add(tvShow)
        }
        Log.d("MovieRepotv", "$listTvShow")
        tvShowResult.postValue(listTvShow)
        return tvShowResult
    }
}