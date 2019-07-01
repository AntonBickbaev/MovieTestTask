package com.project.asmv.movietesttask.domain.movie_list

import com.project.asmv.movietesttask.unit.data.movie_list.MovieInfo
import com.project.asmv.movietesttask.database.cache.last_update_cache.LastUpdateCache
import com.project.asmv.movietesttask.database.cache.popular_movie_cache.PopularMovieCache
import com.project.asmv.movietesttask.repository.movie_list.PopularMovieRepository
import com.project.asmv.movietesttask.unit.mapper.PopularMovieMapper
import io.reactivex.Single
import java.net.UnknownHostException
import javax.inject.Inject

class PopularMovieInteractorImpl @Inject constructor(
    private var popularMovieRepository: PopularMovieRepository,
    private var popularMovieCache: PopularMovieCache,
    private var poplarMovieMapper: PopularMovieMapper,
    private var lastUpdateCache: LastUpdateCache
) : PopularMovieInteractor {


    override fun getMovieList(): Single<MovieInfo> {
        return lastUpdateCache.getLastTime()
            .flatMap { popularMovieCache.getPopularMovies() }
            .flatMap { poplarMovieMapper.mapToMovieItem(popularMovieListEntity = it) }
            .onErrorResumeNext { throwable ->
                if (throwable is UnknownHostException) {
                    popularMovieCache.getPopularMovies()
                        .flatMap { poplarMovieMapper.mapToMovieItem(throwable, it) }

                } else {
                    popularMovieRepository.getPopularMovie()
                        .flatMap { poplarMovieMapper.mapToMovieEntity(it) }
                        .doOnSuccess { popularMovieCache.insert(it) }
                        .flatMap { poplarMovieMapper.mapToMovieItem(throwable,it) }

                }
            }

    }


}