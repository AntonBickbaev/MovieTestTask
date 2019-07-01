package com.project.asmv.movietesttask.di.movie_detail

import com.project.asmv.movietesttask.domain.movie_detail.MovieDetailInteractor
import com.project.asmv.movietesttask.domain.movie_detail.MovieDetailInteractorImpl
import com.project.asmv.movietesttask.presentation.movie_detail.view.MovieDetailFragment
import com.project.asmv.movietesttask.presentation.movie_detail.presenter.MovieDetailPresenter
import com.project.asmv.movietesttask.presentation.movie_detail.presenter.MovieDetailPresenterImpl
import com.project.asmv.movietesttask.presentation.movie_detail.view.MovieDetailView
import com.project.asmv.movietesttask.repository.movie_detail.MovieDetailRepository
import com.project.asmv.movietesttask.repository.movie_detail.MovieDetailRepositoryImpl
import com.project.asmv.movietesttask.unit.mapper.PopularMovieMapper
import com.project.asmv.movietesttask.unit.mapper.PopularMovieMapperImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MovieDetailModule {
    @Binds
    abstract fun bindMovieDetailView(movieDetailFragment: MovieDetailFragment): MovieDetailView

    @Binds
    abstract fun bindMovieDetailPresenter(movieDetailPresenter: MovieDetailPresenterImpl): MovieDetailPresenter

    @Binds
    abstract fun bindMovieDetailInteractor(movieDetailInteractor: MovieDetailInteractorImpl): MovieDetailInteractor

    @Binds
    abstract fun bindPopularMovieMapper(popularMovieMapperImpl: PopularMovieMapperImpl): PopularMovieMapper

    @Binds
    abstract fun bindMovieDetailRepository(MovieDetailRepository: MovieDetailRepositoryImpl): MovieDetailRepository
}