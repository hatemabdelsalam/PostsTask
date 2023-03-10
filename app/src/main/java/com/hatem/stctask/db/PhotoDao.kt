package com.hatem.stctask.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hatem.stctask.shared.model.PhotosModel

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(photo: List<PhotosModel>)

    @Query("SELECT * FROM photo ORDER BY id DESC")
    suspend fun getPhotos(): List<PhotosModel>

}