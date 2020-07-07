package com.hb.cleanarchitecturesample.baseui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hb.cleanarchitecturesample.commun.AppRouter
import com.hb.cleanarchitecturesample.commun.AppSharedPreferences

abstract class BaseFragment : Fragment() {

    protected lateinit var activity: BaseActivity
    protected lateinit var appRouter: AppRouter
    protected lateinit var sharedPreferences: AppSharedPreferences

    protected abstract val layoutResId: Int
    abstract fun initViews()
    abstract fun inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        initViews()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        activity = context as BaseActivity
        appRouter = activity.appRouter
        sharedPreferences = activity.sharedPreferences
    }


    protected fun toggleLoading(show: Boolean) {
        if (isAdded) {
            activity.toggleLoading(show)
        }
    }

}