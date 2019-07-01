package com.project.asmv.movietesttask.presentation.movie_detail.presenter

import com.project.asmv.movietesttask.unit.base.BaseView

interface MovieDetailPresenter : BaseView {
    fun getDetailMovie(id: Long)
}