package com.hatem.stctask.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hatem.stctask.db.PhotoDatabase
import com.hatem.stctask.network.ApiService
import com.hatem.stctask.shared.model.PhotosModel
import com.hatem.stctask.utils.Constants.NETWORK_PAGE_SIZE

class PhotoPagingSource (private val apiService: ApiService, private val db:PhotoDatabase) :
    PagingSource<Int, PhotosModel>() {
    private val initialLoadSize = 1

    override fun getRefreshKey(state: PagingState<Int, PhotosModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotosModel> {
        val position = params.key ?: initialLoadSize
        val offset = if (params.key != null) ((position - 1) * NETWORK_PAGE_SIZE) + 1 else initialLoadSize

        return try {
            val result = apiService.getPhotos(start = offset, limit = params.loadSize)
            val nextKey = if (result.isEmpty()) {
                null
            } else {
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }

            db.getPhotoDao().upsert(result)
            LoadResult.Page(
                data = result,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}