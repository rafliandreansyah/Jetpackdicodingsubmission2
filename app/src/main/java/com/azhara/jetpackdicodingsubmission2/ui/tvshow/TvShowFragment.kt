package com.azhara.jetpackdicodingsubmission2.ui.tvshow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.azhara.jetpackdicodingsubmission2.R
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.TvShowEntity
import com.azhara.jetpackdicodingsubmission2.ui.tvshow.adapter.TvShowAdapter
import com.azhara.jetpackdicodingsubmission2.ui.tvshow.viewmodel.TvShowViewModel
import com.azhara.jetpackdicodingsubmission2.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        val tvShowAdapter = TvShowAdapter()
        viewModel.getAllTvShow().observe(viewLifecycleOwner, Observer { data ->
            tvShowAdapter.setData(data as ArrayList<TvShowEntity>)
            Log.d("TvShowFragment", "$data")
        })

        with(rv_tvshow){
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

}
