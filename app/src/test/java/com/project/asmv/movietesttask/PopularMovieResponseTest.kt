package com.project.asmv.movietesttask

import com.google.gson.Gson
import com.project.asmv.movietesttask.network.ApiService
import com.project.asmv.movietesttask.repository.movie_list.PopularMovieRepositoryImpl
import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieListResponse
import io.reactivex.Single
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito


class PopularMovieResponseTest : BaseTest() {

    @Mock
    lateinit var apiService: ApiService

    @InjectMocks
    lateinit var popularMovieRepository: PopularMovieRepositoryImpl

    //TODO ¯\_(ツ)_/¯ нужен контекст бизнес логики что бы дописать тест(какие поля будут использоватся прийдут и так далие)
    @Test
    fun checkResponse() {
        Mockito.`when`(apiService.getPopularMovie()).thenReturn(Single.create { e ->
            val result = loadJSONFromAsset(this, "MovieResponse.JSON")
            e.onSuccess(Gson().fromJson(result, PopularMovieListResponse::class.java))
        })
        popularMovieRepository.getPopularMovie()
            .test()
            .assertValue { it.page == 1 }
            .assertValue { it.results?.isNotEmpty() == true }
            .assertValue { movieListResponse -> movieListResponse.results?.all { it.title?.isNotEmpty() == true } == true }
            .assertValue { movieListResponse -> movieListResponse.results?.all { it.posterPath?.isNotEmpty() == true } == true }
            .assertValue { movieListResponse -> movieListResponse.results?.all { it.overview?.isNotEmpty() == true } == true }

    }

}