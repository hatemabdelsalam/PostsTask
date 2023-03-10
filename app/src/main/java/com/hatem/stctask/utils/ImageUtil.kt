package com.hatem.stctask.utils


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.hatem.stctask.R
import com.hatem.stctask.network.Urls

class ImageUtil {

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadPicture(imageView: ImageView, url: String?) {
            Glide.with(imageView.context).load(url).placeholder(R.drawable.placeholder_img).into(imageView)
        }
    }
}