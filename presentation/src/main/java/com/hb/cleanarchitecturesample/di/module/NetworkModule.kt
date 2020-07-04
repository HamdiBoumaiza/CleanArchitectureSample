package com.hb.cleanarchitecturesample.di.module

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.hb.cleanarchitecturesample.BuildConfig
import com.hb.data.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        const val API_URL = "https://api.unsplash.com/"
        const val CACHE_SIZE = 10 * 1024 * 1024 // 10 MB

        const val CONNECT_TIMEOUT = "10"
        const val WRITE_TIMEOUT = "60"
        const val READ_TIMEOUT = "30"
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(API_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)

        if (BuildConfig.DEBUG)
            client.addNetworkInterceptor(StethoInterceptor())
        return client.build()
    }

    @Provides
    @Singleton
    fun providesOkhttpCache(context: Context) = Cache(context.cacheDir, CACHE_SIZE.toLong())


    @Provides
    @Singleton
    fun providesConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}