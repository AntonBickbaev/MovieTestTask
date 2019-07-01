package com.project.asmv.movietesttask.di.movie_list

import com.project.asmv.movietesttask.domain.movie_list.PopularMovieInteractor
import com.project.asmv.movietesttask.domain.movie_list.PopularMovieInteractorImpl
import com.project.asmv.movietesttask.presentation.movie_list.MovieListFragment
import com.project.asmv.movietesttask.presentation.movie_list.MovieListPresenter
import com.project.asmv.movietesttask.presentation.movie_list.MovieListPresenterImpl
import com.project.asmv.movietesttask.presentation.movie_list.MovieListView
import com.project.asmv.movietesttask.repository.movie_list.PopularMovieRepository
import com.project.asmv.movietesttask.repository.movie_list.PopularMovieRepositoryImpl
import com.project.asmv.movietesttask.unit.PopularMovieMapper
import com.project.asmv.movietesttask.unit.PopularMovieMapperImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MovieListModule {

    @Binds
    abstract fun bindMovieListView(movieListFragment: MovieListFragment): MovieListView

    @Binds
    abstract fun bindMovieListPresenter(movieListPresenter: MovieListPresenterImpl): MovieListPresenter

    @Binds
    abstract fun bindPopularMovieInteractor(popularMovieInteractor: PopularMovieInteractorImpl): PopularMovieInteractor

    @Binds
    abstract fun bindPopularMovieMapper(popularMovieMapperImpl: PopularMovieMapperImpl): PopularMovieMapper

    @Binds
    abstract fun bindPopularMovieRepository(popularMovieRepository: PopularMovieRepositoryImpl): PopularMovieRepository
}