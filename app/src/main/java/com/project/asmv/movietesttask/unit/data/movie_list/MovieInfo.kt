package com.project.asmv.movietesttask.unit.data.movie_list

data class MovieInfo(
    var isError : Boolean = false,
    var throwable: Throwable? = null,
    var popularMovieItem : ArrayList<PopularMovieItem> = arrayListOf()
)