package com.project.asmv.movietesttask.di

import com.project.asmv.movietesttask.di.movie_detail.MovieDetailModule
import com.project.asmv.movietesttask.di.movie_list.MovieListModule
import com.project.asmv.movietesttask.presentation.movie_detail.MovieDetailFragment
import com.project.asmv.movietesttask.presentation.movie_list.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [MovieListModule::class])
    abstract fun bindMovieListFragment(): MovieListFragment

    @ContributesAndroidInjector(modules = [MovieDetailModule::class])
    abstract fun bindMovieDetailFragment(): MovieDetailFragment
}