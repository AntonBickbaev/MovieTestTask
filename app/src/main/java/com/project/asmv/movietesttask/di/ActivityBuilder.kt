package com.project.asmv.movietesttask.di

import com.project.asmv.movietesttask.presentation.MovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindMovieActivity(): MovieActivity
}