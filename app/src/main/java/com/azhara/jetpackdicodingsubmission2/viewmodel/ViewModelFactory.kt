package com.azhara.jetpackdicodingsubmission2.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.azhara.jetpackdicodingsubmission2.data.source.MoviesRepository
import com.azhara.jetpackdicodingsubmission2.di.Injection
import com.azhara.jetpackdicodingsubmission2.ui.movies.viewmodel.MoviesViewModel
import com.azhara.jetpackdicodingsubmission2.ui.tvshow.viewmodel.TvShowViewModel

class ViewModelFactory private constructor(private val moviesRepository: MoviesRepository): ViewModelProvider.NewInstanceFactory(){

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(context){
                instance ?: ViewModelFactory(Injection.provideRepository())
            }
    }

    @Suppress
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(
                    moviesRepository
                ) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(
                    moviesRepository
                ) as T
            }
            else -> throw Throwable("Unknown View Model class: " + modelClass.name)
        }
    }

}