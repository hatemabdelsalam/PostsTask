package com.hatem.stctask.home.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.hatem.stctask.R
import com.hatem.stctask.databinding.ActivityHomeBinding
import com.hatem.stctask.details.ui.DetailsActivity
import com.hatem.stctask.home.PhotoViewModel
import com.hatem.stctask.shared.model.PhotosModel
import com.hatem.stctask.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), PhotoAdapter.PhotoActions {

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<PhotoViewModel>()
    lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        photoAdapter = PhotoAdapter(this)
        binding.photosRv.adapter = photoAdapter

        initObservers()

    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.getPhotos().collectLatest {
                photoAdapter.submitData(it)
            }
        }
    }

    override fun onPhotoClicked(photo: PhotosModel) {
        startActivity(Intent(this, DetailsActivity::class.java).apply {
            putExtra(Constants.EXTRA_PHOTO, photo)
        })
    }
}