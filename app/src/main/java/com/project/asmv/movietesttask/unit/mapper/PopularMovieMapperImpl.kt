package com.project.asmv.movietesttask.unit.mapper

import com.project.asmv.movietesttask.database.entity.PopularMovieEntity
import com.project.asmv.movietesttask.unit.data.movie_details.MovieDetail
import com.project.asmv.movietesttask.unit.data.movie_list.MovieInfo
import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieItem
import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieListResponse
import io.reactivex.Single
import java.net.UnknownHostException
import javax.inject.Inject

class PopularMovieMapperImpl @Inject constructor() : PopularMovieMapper {

    companion object {
        const val ADDRESS_PREFIX = "https://image.tmdb.org/t/p/w500/"
    }

    override fun mapToMovieEntity(popularMovieListResponse: PopularMovieListResponse): Single<ArrayList<PopularMovieEntity>> {
        return Single.create { emmiter ->
            val resultList: ArrayList<PopularMovieEntity> = popularMovieListResponse.results?.flatMap { popularMovie ->
                arrayListOf(
                    PopularMovieEntity(
                        idMovie = popularMovie.id,
                        posterPath = popularMovie.posterPath,
                        releaseDate = popularMovie.releaseDate,
                        title = popularMovie.title,
                        voteAverage = popularMovie.voteAverage,
                        adult = popularMovie.adult,
                        backdropPath = popularMovie.backdropPath,
                        genreIds = popularMovie.genreIds,
                        originalLanguage = popularMovie.originalLanguage,
                        originalTitle = popularMovie.originalTitle,
                        overview = popularMovie.overview,
                        popularity = popularMovie.popularity,
                        video = popularMovie.video,
                        voteCount = popularMovie.voteCount
                    )
                )


            } as ArrayList<PopularMovieEntity>
            emmiter.onSuccess(resultList)

        }
    }

    override fun mapToMovieItem(
        throwable: Throwable?,
        popularMovieListEntity: List<PopularMovieEntity>
    ): Single<MovieInfo> {
        return Single.create { emmiter ->
            val resultList: ArrayList<PopularMovieItem> = popularMovieListEntity.flatMap { popularMovie ->
                arrayListOf(
                    PopularMovieItem(
                        id = popularMovie.idMovie,
                        posterPath = makeImageAddress(popularMovie.posterPath),
                        title = popularMovie.title
                    )
                )


            } as ArrayList<PopularMovieItem>
            val isNetworkError = throwable is UnknownHostException
            emmiter.onSuccess(MovieInfo(throwableMsg = throwable?.message, popularMovieItem = resultList, isNetworkError = isNetworkError))

        }
    }

    override fun mapToMovieDetail(popularMovieEntity: PopularMovieEntity): Single<MovieDetail> {
        return Single.create { emmiter ->
            val movieDetail = MovieDetail(
                id = popularMovieEntity.idMovie,
                posterPath = makeImageAddress(popularMovieEntity.posterPath),
                title = popularMovieEntity.title,
                overview = popularMovieEntity.overview
            )
            emmiter.onSuccess(movieDetail)
        }
    }

    private fun makeImageAddress(posterPath: String?): String = ADDRESS_PREFIX + posterPath

}