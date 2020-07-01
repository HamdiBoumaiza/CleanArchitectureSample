package com.proxym.woqode.utils

import android.content.Context
import java.util.*

class LanguageUtils {

    companion object {

        private fun setSelectedLocale(context: Context, language: String) {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val resources = context.resources
            val configuration = resources.configuration
            configuration.locale = locale
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }

        fun getLanguagesData() = listOf("EN", "AR")
    }
}