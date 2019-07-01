package com.project.asmv.movietesttask.repository.movie_list

import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieListResponse
import io.reactivex.Single

interface PopularMovieRepository {
    fun getPopularMovie(): Single<PopularMovieListResponse>
}
