package com.hatem.stctask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hatem.stctask.shared.model.PhotosModel


@Database(
    entities = [PhotosModel::class],
    version = 1
)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun getPhotoDao(): PhotoDao
}