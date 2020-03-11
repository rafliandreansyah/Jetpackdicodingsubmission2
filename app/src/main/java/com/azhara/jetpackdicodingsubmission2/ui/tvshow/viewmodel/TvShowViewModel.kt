package com.azhara.jetpackdicodingsubmission2.ui.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.azhara.jetpackdicodingsubmission2.data.source.MoviesRepository
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.TvShowEntity

class TvShowViewModel(private val academyRepository: MoviesRepository): ViewModel() {

    fun getAllTvShow(): LiveData<List<TvShowEntity>> = academyRepository.getAllTvShow()

}