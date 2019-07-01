package com.project.asmv.movietesttask.di

import android.app.Application
import android.content.Context
import com.project.asmv.movietesttask.unit.error.ErrorHandler
import com.project.asmv.movietesttask.unit.error.ErrorHandlerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideErrorHandler(context: Context): ErrorHandler {
        return ErrorHandlerImpl(context)
    }
}