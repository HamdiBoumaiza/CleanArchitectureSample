package com.hb.cleanarchitecturesample.commun

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.gson.GsonBuilder
import com.hb.cleanarchitecturesample.BuildConfig
import javax.inject.Singleton

@Singleton
class AppSharedPreferences(context: Context) {

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val prefs = EncryptedSharedPreferences.create(
        BuildConfig.APPLICATION_ID,
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private val gson by lazy { GsonBuilder().create() }

    fun <T> putObject(key: String, y: T) {
        val inString = gson.toJson(y)
        prefs.edit().putString(key, inString).apply()
    }

    fun <T> getObject(key: String, c: Class<T>): T? {
        val value = prefs.getString(key, null)
        return if (value != null) {
            gson.fromJson(value, c)
        } else {
            null
        }
    }

    fun deleteObject(key: String) {
        prefs.edit().remove(key).apply()
    }

}