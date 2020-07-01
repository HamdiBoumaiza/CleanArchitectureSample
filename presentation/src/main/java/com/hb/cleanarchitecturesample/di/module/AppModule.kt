package com.hb.cleanarchitecturesample.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hb.cleanarchitecturesample.commun.AppSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Context = appContext.applicationContext

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder().apply {
            excludeFieldsWithoutExposeAnnotation()
            setPrettyPrinting()
        }.serializeNulls().create()
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(): AppSharedPreferences = AppSharedPreferences(appContext)

}