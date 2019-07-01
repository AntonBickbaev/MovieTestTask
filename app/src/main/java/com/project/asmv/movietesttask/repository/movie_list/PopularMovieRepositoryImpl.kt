package com.project.asmv.movietesttask.repository.movie_list

import com.project.asmv.movietesttask.network.ApiService
import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieListResponse
import io.reactivex.Single
import javax.inject.Inject

class PopularMovieRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    PopularMovieRepository {

    override fun getPopularMovie(): Single<PopularMovieListResponse> = apiService.getPopularMovie()

}