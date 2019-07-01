package com.project.asmv.movietesttask.network

import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("movie/popular?api_key=befc7872520fd736c58948abb2f4a53c")
    fun getPopularMovie(): Single<PopularMovieListResponse>
}