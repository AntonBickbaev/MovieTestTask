package com.project.asmv.movietesttask.domain.movie_detail

import com.project.asmv.movietesttask.unit.data.movie_details.MovieDetail
import io.reactivex.Single

interface MovieDetailInteractor {
    fun getPopularMovie(id: Long): Single<MovieDetail>
}