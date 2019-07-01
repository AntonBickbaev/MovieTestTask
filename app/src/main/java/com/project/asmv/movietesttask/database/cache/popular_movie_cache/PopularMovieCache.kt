package com.project.asmv.movietesttask.database.cache.popular_movie_cache

import com.project.asmv.movietesttask.database.entity.PopularMovieEntity
import io.reactivex.Single

interface PopularMovieCache {

    fun insert(popularMovieEntity: List<PopularMovieEntity>)

    fun getPopularMovies(): Single<List<PopularMovieEntity>>

    fun getPopularMovie(id: Long): Single<PopularMovieEntity>

    fun deleteAll()

}