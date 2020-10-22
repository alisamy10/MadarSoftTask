package com.ali.madarsofttask.di

import android.content.Context
import androidx.room.Room
import com.ali.madarsofttask.entity.source.local.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {


    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(context,
        UserDatabase::class.java, "USER_DATABASE_NAME")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideUserDao(db:UserDatabase)=db.getUserDao()


}
