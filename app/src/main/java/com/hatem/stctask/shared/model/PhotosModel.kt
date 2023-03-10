package com.hatem.stctask.shared.model


import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Entity(tableName = "photo")
@Parcelize
data class PhotosModel(
    var albumId: Int,
    @PrimaryKey
    var id: Int,
    var thumbnailUrl: String,
    var title: String,
    var url: String
):Parcelable