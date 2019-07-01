package com.project.asmv.movietesttask.repository.movie_list

import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieListResponse
import com.project.asmv.movietesttask.network.ApiService
import io.reactivex.Single
import javax.inject.Inject

interface PopularMovieRepository {
    fun getPopularMovie(): Single<PopularMovieListResponse>
}

class PopularMovieRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    PopularMovieRepository {

    override fun getPopularMovie(): Single<PopularMovieListResponse> = apiService.getPopularMovie()

}