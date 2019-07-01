package com.project.asmv.movietesttask.presentation.movie_list.view

import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieItem

interface MovieListView {
    fun completableList(popularMovieItemList: ArrayList<PopularMovieItem>)
    fun errorSnackBar(text: String)
}