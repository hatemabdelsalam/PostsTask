package com.hatem.stctask.home

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hatem.stctask.network.ApiService
import com.hatem.stctask.shared.model.PhotosModel
import com.hatem.stctask.utils.Constants.NETWORK_PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(private val photoRepository: PhotoRepository) : ViewModel() {

    suspend fun getPhotos(): Flow<PagingData<PhotosModel>> = photoRepository.getPhoto()

}

