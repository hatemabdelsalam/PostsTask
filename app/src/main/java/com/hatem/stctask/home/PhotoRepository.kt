package com.hatem.stctask.home

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hatem.stctask.db.PhotoDatabase
import com.hatem.stctask.network.ApiService
import com.hatem.stctask.shared.model.PhotosModel
import com.hatem.stctask.utils.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val apiService: ApiService, private val db:PhotoDatabase) {

    suspend fun getPhoto(): Flow<PagingData<PhotosModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {PhotoPagingSource(apiService = apiService, db)}
        ).flow
    }

}