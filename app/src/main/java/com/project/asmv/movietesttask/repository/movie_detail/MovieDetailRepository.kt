package com.project.asmv.movietesttask.repository.movie_detail

import com.project.asmv.movietesttask.database.entity.PopularMovieEntity
import io.reactivex.Single

interface MovieDetailRepository {
    fun getPopularMovie(id: Long): Single<PopularMovieEntity>
}