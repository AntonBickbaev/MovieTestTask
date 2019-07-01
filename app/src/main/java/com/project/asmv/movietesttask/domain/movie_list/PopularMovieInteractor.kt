package com.project.asmv.movietesttask.domain.movie_list

import com.project.asmv.movietesttask.unit.data.movie_list.MovieInfo
import io.reactivex.Single

interface PopularMovieInteractor {
    fun getMovieList(): Single<MovieInfo>
}