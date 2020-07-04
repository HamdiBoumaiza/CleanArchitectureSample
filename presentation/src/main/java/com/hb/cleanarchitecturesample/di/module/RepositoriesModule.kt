package com.hb.cleanarchitecturesample.di.module

import com.hb.data.ApiService
import com.hb.data.datasource.WallpaperDataSourceImpl
import com.hb.data.repository.WallpaperRepositoryImpl
import com.hb.domain.repository.WallpaperRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideAppRepository(apiService: ApiService): WallpaperRepository {
        val appRemoteDataSource = WallpaperDataSourceImpl(apiService)
        return WallpaperRepositoryImpl(appRemoteDataSource)
    }

}