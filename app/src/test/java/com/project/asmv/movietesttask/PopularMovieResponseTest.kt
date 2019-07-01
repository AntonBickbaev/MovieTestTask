package com.project.asmv.movietesttask

import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovie
import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieListResponse
import com.project.asmv.movietesttask.network.ApiService
import com.project.asmv.movietesttask.repository.movie_list.PopularMovieRepositoryImpl
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PopularMovieResponseTest {

    @Mock
    lateinit var apiService: ApiService

    @InjectMocks
    lateinit var popularMovieRepository: PopularMovieRepositoryImpl

    private val popularMovieResponse: PopularMovieListResponse =
        PopularMovieListResponse(
            page = 1,
            results = arrayListOf(
                PopularMovie(
                    voteCount = 374,
                    id = 0,
                    video = false,
                    overview = "Какое-то длинное описание",
                    popularity = 11.1,
                    originalTitle = "Сумерки",
                    originalLanguage = "ru",
                    genreIds = listOf(10, 10),
                    backdropPath = "https//",
                    adult = false,
                    voteAverage = 12.1,
                    title = "Сумерки",
                    releaseDate = "2019.06.30",
                    posterPath = ".jpg"
                )
            ),
            totalPages = 999,
            totalResults = 1000
        )


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    //TODO ¯\_(ツ)_/¯ нужен контекст бизнес логики что бы дописать тест(какие поля будут использоватся прийдут и так далие)
    @Test
    fun checkResponse() {
        Mockito.`when`(apiService.getPopularMovie()).thenReturn(Single.fromCallable { popularMovieResponse })
        popularMovieRepository.getPopularMovie()
            .test()
            .assertValue { it.page == 1 }
            .assertValue { it.results?.isNotEmpty() == true }
            .assertValue { movieListResponse -> movieListResponse.results?.all { it.title?.isNotEmpty() == true } == true }
            .assertValue { movieListResponse -> movieListResponse.results?.all { it.posterPath?.isNotEmpty() == true } == true }
            .assertValue { movieListResponse -> movieListResponse.results?.all { it.overview?.isNotEmpty() == true } == true }


    }
}