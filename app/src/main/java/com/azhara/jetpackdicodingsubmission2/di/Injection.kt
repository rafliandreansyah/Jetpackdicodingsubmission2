package com.azhara.jetpackdicodingsubmission2.di

import com.azhara.jetpackdicodingsubmission2.data.source.MoviesRepository
import com.azhara.jetpackdicodingsubmission2.data.source.remote.RemoteDataSource
import com.azhara.jetpackdicodingsubmission2.utils.JsonHelper

object Injection {

    fun provideRepository(): MoviesRepository{
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper())

        return MoviesRepository.getInstance(remoteDataSource)
    }
}