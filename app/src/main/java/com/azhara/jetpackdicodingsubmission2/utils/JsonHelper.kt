package com.azhara.jetpackdicodingsubmission2.utils

import android.util.Log
import com.azhara.jetpackdicodingsubmission2.BuildConfig
import com.azhara.jetpackdicodingsubmission2.data.source.remote.response.MoviesResponse
import com.azhara.jetpackdicodingsubmission2.data.source.remote.response.TvShowResponse
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class JsonHelper {

    private val apiKey = BuildConfig.MOVIE_DB_API_KEY
    private val TAG = JsonHelper::class.java.simpleName

    fun loadMovies(): ArrayList<MoviesResponse>{
        val listMovies = ArrayList<MoviesResponse>()
        val client = AsyncHttpClient()
        val url = "https://api.themoviedb.org/3/movie/popular?api_key=${apiKey}&language=en-US&page=1"


        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                try {
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val list = responseObject.getJSONArray("results")

                    for (i in 0 until list.length()){
                        val movieData = list.getJSONObject(i)
                        val movie = MoviesResponse()

                        movie.id = movieData.getString("id")
                        movie.title = movieData.getString("title")
                        movie.overview = movieData.getString("overview")
                        movie.release = movieData.getString("release_date")
                        movie.vote_average = movieData.getString("vote_average")
                        movie.backdrop_path = movieData.getString("backdrop_path")
                        movie.poster_path = movieData.getString("poster_path")
                        listMovies.add(movie)
                    }
                    Log.d("Json helper", "$listMovies")

                }catch (e: Exception){
                    Log.e(TAG, "error onSuccess load movie: $e")
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Log.e(TAG, "error onFailure load movie: $error")
            }

        })

        return listMovies
    }

    fun loadTvShow(): ArrayList<TvShowResponse>{
        val listTvShow = ArrayList<TvShowResponse>()
        val client = AsyncHttpClient()
        val url = "https://api.themoviedb.org/3/tv/popular?api_key=${apiKey}&language=en-US&page=1"

        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                try {
                    val result = String(responseBody)
                    val responseBody = JSONObject(result)
                    val list = responseBody.getJSONArray("results")

                    for (i in 0 until list.length()){
                        val tvData = list.getJSONObject(i)
                        val tvShow = TvShowResponse()

                        tvShow.id = tvData.getString("id")
                        tvShow.title = tvData.getString("name")
                        tvShow.overview = tvData.getString("overview")
                        tvShow.release = tvData.getString("first_air_date")
                        tvShow.vote_average = tvData.getString("vote_average")
                        tvShow.backdrop_path = tvData.getString("backdrop_path")
                        tvShow.poster_path = tvData.getString("poster_path")
                        listTvShow.add(tvShow)
                    }

                }catch (e: Exception){
                    Log.e(TAG, "error onSuccess load tv: $e")
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Log.e(TAG, "error onFailure load tv: $error")
            }

        })
        return listTvShow
    }

}