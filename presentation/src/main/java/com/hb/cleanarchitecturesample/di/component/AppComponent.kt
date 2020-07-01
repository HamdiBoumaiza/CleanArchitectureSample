package com.hb.cleanarchitecturesample.di.component

import android.content.Context
import com.hb.cleanarchitecturesample.commun.AppSharedPreferences
import com.hb.cleanarchitecturesample.di.module.AppModule
import com.hb.cleanarchitecturesample.di.module.CoroutinesModule
import com.hb.cleanarchitecturesample.di.module.RepositoriesModule
import com.hb.cleanarchitecturesample.di.viewmodels.ViewModelModule
import com.hb.cleanarchitecturesample.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, CoroutinesModule::class, RepositoriesModule::class, ViewModelModule::class])
interface AppComponent {
    fun context(): Context
    fun appSharedPref(): AppSharedPreferences

    fun inject(mainActivity: MainActivity)
}
