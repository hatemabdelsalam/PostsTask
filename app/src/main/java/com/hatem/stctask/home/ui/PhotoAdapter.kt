package com.hatem.stctask.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hatem.stctask.databinding.ItemPhotoBinding
import com.hatem.stctask.shared.model.PhotosModel

class PhotoAdapter(val photoActions: PhotoActions):PagingDataAdapter<PhotosModel, PhotoAdapter.ViewHolder>(DiffUtilCallBack) {

    inner class ViewHolder(private val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(photo:PhotosModel){
            binding.photo = photo
            binding.root.setOnClickListener {
                photoActions.onPhotoClicked(photo)
            }
        }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<PhotosModel>(){
        override fun areItemsTheSame(oldItem: PhotosModel, newItem: PhotosModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PhotosModel, newItem: PhotosModel): Boolean {
            return oldItem == newItem
        }

    }

    interface PhotoActions{
        fun onPhotoClicked(photo: PhotosModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}