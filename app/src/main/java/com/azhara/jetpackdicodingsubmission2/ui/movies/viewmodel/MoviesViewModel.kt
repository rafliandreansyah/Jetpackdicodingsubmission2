package com.azhara.jetpackdicodingsubmission2.ui.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.azhara.jetpackdicodingsubmission2.data.source.MoviesRepository
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.MoviesEntity

class MoviesViewModel(private val academyRepository: MoviesRepository): ViewModel() {

    fun getAllMovies(): LiveData<List<MoviesEntity>> = academyRepository.getAllMovies()

}