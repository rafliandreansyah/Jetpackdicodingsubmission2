package com.azhara.jetpackdicodingsubmission2.ui.tvshow.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azhara.jetpackdicodingsubmission2.R
import com.azhara.jetpackdicodingsubmission2.data.source.local.entity.TvShowEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.tvshow_item.view.*

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewModel>() {

    private val list = ArrayList<TvShowEntity>()

    fun setData(tvshow: ArrayList<TvShowEntity>){
        list.clear()
        list.addAll(tvshow)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewModel = TvShowViewModel(LayoutInflater.from(parent.context).inflate(R.layout.tvshow_item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TvShowViewModel, position: Int) {
        holder.bind(list[position])
    }

    inner class TvShowViewModel(view: View): RecyclerView.ViewHolder(view){
        fun bind(tvShow: TvShowEntity){
            with(itemView){
                tv_title_tvshow.text = tvShow.name
                tv_description_tvshow.text = tvShow.overview
                Glide.with(itemView)
                    .load(tvShow.poster_path)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh_black_24dp).error(R.drawable.ic_broken_image_black_24dp))
                    .centerCrop()
                    .into(img_tvshow)
            }
        }
    }
}