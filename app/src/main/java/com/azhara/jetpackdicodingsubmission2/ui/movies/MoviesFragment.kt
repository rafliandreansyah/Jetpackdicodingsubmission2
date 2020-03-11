package com.azhara.jetpackdicodingsubmission2.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.azhara.jetpackdicodingsubmission2.R
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.MoviesEntity
import com.azhara.jetpackdicodingsubmission2.ui.movies.adapter.MoviesAdapter
import com.azhara.jetpackdicodingsubmission2.ui.movies.viewmodel.MoviesViewModel
import com.azhara.jetpackdicodingsubmission2.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movies.*

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

        val moviesAdapter = MoviesAdapter()

        viewModel.getAllMovies().observe(viewLifecycleOwner, Observer { data ->
            moviesAdapter.setData(data as ArrayList<MoviesEntity>)
            Log.d("MoviesFragment", "$data")
        })

        with(rv_movies){
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = moviesAdapter
        }

    }
}
