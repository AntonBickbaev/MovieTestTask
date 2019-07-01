package com.project.asmv.movietesttask.unit.mapper

import com.project.asmv.movietesttask.database.entity.PopularMovieEntity
import com.project.asmv.movietesttask.unit.data.movie_details.MovieDetail
import com.project.asmv.movietesttask.unit.data.movie_list.MovieInfo
import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieListResponse
import io.reactivex.Single

interface PopularMovieMapper {
    fun mapToMovieEntity(popularMovieListResponse: PopularMovieListResponse): Single<ArrayList<PopularMovieEntity>>
    fun mapToMovieItem(throwable: Throwable? = null, popularMovieListEntity: List<PopularMovieEntity>): Single<MovieInfo>
    fun mapToMovieDetail(popularMovieEntity: PopularMovieEntity): Single<MovieDetail>
}