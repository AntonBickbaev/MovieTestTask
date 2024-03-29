package com.project.asmv.movietesttask

import com.facebook.stetho.Stetho
import com.project.asmv.movietesttask.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun onCreate() {
        Stetho.initializeWithDefaults(this)
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent as AndroidInjector<out DaggerApplication>
    }

}