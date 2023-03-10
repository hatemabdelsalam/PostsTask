package com.hatem.stctask.details.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hatem.stctask.R
import com.hatem.stctask.databinding.ActivityDetailsBinding
import com.hatem.stctask.shared.model.PhotosModel
import com.hatem.stctask.utils.Constants

class DetailsActivity : AppCompatActivity() {

    private var _binding:ActivityDetailsBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.EXTRA_PHOTO, PhotosModel::class.java)?.let { photo ->
                binding.photo = photo
            }
        }else{
            intent.getParcelableExtra<PhotosModel>(Constants.EXTRA_PHOTO)?.let { photo ->
                binding.photo = photo
            }
        }
    }
}