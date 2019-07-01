package com.project.asmv.movietesttask.domain.movie_detail

import com.project.asmv.movietesttask.unit.data.movie_details.MovieDetail
import com.project.asmv.movietesttask.repository.movie_detail.MovieDetailRepository
import com.project.asmv.movietesttask.unit.PopularMovieMapper
import io.reactivex.Single
import javax.inject.Inject

interface MovieDetailInteractor {
    fun getPopularMovie(id: Long): Single<MovieDetail>
}

class MovieDetailInteractorImpl @Inject constructor(
    private var movieDetailRepository: MovieDetailRepository,
    private var poplarMovieMapper: PopularMovieMapper
) : MovieDetailInteractor {

    override fun getPopularMovie(id: Long): Single<MovieDetail> {
        return movieDetailRepository.getPopularMovie(id)
            .flatMap { poplarMovieMapper.mapToMovieDetail(it) }
    }

}