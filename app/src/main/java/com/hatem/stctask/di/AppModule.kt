package com.hatem.stctask.di

import android.app.Application
import androidx.room.Room
import com.hatem.stctask.db.PhotoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideWeatherDatabase(app:Application):PhotoDatabase{
        return Room.databaseBuilder(app, PhotoDatabase::class.java, "PhotoDB.db").build()
    }
}