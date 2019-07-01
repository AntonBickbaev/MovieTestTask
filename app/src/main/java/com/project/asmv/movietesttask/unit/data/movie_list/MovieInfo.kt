package com.project.asmv.movietesttask.unit.data.movie_list

data class MovieInfo(
    var isNetworkError : Boolean = false,
    var throwableMsg: String? = null,
    var popularMovieItem : ArrayList<PopularMovieItem> = arrayListOf()
)