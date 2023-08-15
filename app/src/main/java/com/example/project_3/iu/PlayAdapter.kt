package com.example.project_3.iu

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.project_3.data.PlaylistModel
import com.example.project_3.databinding.ItemYoutubeBinding

class PlayAdapter:Adapter<PlayAdapter.PlayViewHolder>() {
    private var list = mutableListOf<PlaylistModel.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(lists: List<PlaylistModel.Item>) {
        this.list = lists as MutableList<PlaylistModel.Item>
        notifyDataSetChanged()
    }

    class PlayViewHolder(private val binding: ItemYoutubeBinding):ViewHolder(binding.root) {
        fun onBind(item: PlaylistModel.Item) {
            binding.nameVideo.text = item.snippet.title
            binding.colVideo.text = item.contentDetails.itemCount.toString() + " video series"
            binding.imageList.loadImage(item.snippet.thumbnails.default.url)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayViewHolder {
        return PlayViewHolder(ItemYoutubeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()= list.size

    override fun onBindViewHolder(holder: PlayViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}

fun ImageView.loadImage(text:String){
    Glide.with(this).load(text).into(this)
}