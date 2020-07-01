package com.hb.cleanarchitecturesample.commun

import android.app.Activity
import android.content.Intent
import com.hb.cleanarchitecturesample.baseui.BaseActivity
import java.io.Serializable


class AppRouter constructor(private val activity: BaseActivity) {

    fun finish() {
        activity.finish()
        activity.overridePendingTransition(0, 0)
    }

    fun goToActivity(toActivity: Class<out Activity>, finish: Boolean = false) {
        val intent = Intent(activity, toActivity)
        activity.startActivity(intent)
        if (finish) {
            activity.finish()
            activity.overridePendingTransition(0, 0)
        }
    }


    fun goToActivityWithExtras(
        toActivity: Class<out Activity>,
        vararg params: Pair<String, Any?>,
        finish: Boolean = false
    ) {
        val intent = Intent(activity, toActivity)
        params.forEach {
            when (val value = it.second) {
                null -> intent.putExtra(it.first, null as Serializable?)
                is String -> intent.putExtra(it.first, value)
                is Serializable -> intent.putExtra(it.first, value)
                is Boolean -> intent.putExtra(it.first, value)
                is Int -> intent.putExtra(it.first, value)
            }
        }
        activity.startActivity(intent)
        if (finish) {
            activity.finish()
            activity.overridePendingTransition(0, 0)
        }
    }
}