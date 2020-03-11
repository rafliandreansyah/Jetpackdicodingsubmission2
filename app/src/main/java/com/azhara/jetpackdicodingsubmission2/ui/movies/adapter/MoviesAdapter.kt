package com.azhara.jetpackdicodingsubmission2.ui.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azhara.jetpackdicodingsubmission2.R
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.MoviesEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.movies_item.view.*

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    private val list =  ArrayList<MoviesEntity>()

    fun setData(movie: ArrayList<MoviesEntity>){
        list.clear()
        list.addAll(movie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder = MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movies_item, parent, false))


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class MoviesViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(movie: MoviesEntity){
            with(itemView){
                tv_title_movies.text = movie.title
                tv_description_movies.text = movie.overview
                Glide.with(itemView)
                    .load(movie.poster_path)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh_black_24dp).error(R.drawable.ic_broken_image_black_24dp))
                    .centerCrop()
                    .into(img_movies)
            }
        }
    }

}