package com.project.asmv.movietesttask.repository.movie_detail

import com.project.asmv.movietesttask.database.cache.PopularMovieCache
import com.project.asmv.movietesttask.database.entity.PopularMovieEntity
import io.reactivex.Single
import javax.inject.Inject

interface MovieDetailRepository {
    fun getPopularMovie(id: Long): Single<PopularMovieEntity>
}

class MovieDetailRepositoryImpl @Inject constructor(private var popularMovieCache: PopularMovieCache) :
    MovieDetailRepository {

    override fun getPopularMovie(id: Long): Single<PopularMovieEntity> = popularMovieCache.getPopularMovie(id)

}