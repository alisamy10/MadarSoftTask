package com.ali.madarsofttask.di


import com.ali.madarsofttask.entity.UserRepository
import com.ali.madarsofttask.entity.source.local.IOfflineDataSource
import com.ali.madarsofttask.entity.source.local.OfflineSourcesRoomBasedImpl
import com.ali.madarsofttask.entity.source.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(iOfflineDataSource: IOfflineDataSource)
            = UserRepository(iOfflineDataSource)

    @Provides
    @Singleton
    fun provideIOfflineDataSource (homeDao: UserDao)
            = OfflineSourcesRoomBasedImpl(homeDao) as IOfflineDataSource


}