package com.project.asmv.movietesttask.presentation.movie_detail.presenter

import com.project.asmv.movietesttask.domain.movie_detail.MovieDetailInteractor
import com.project.asmv.movietesttask.presentation.movie_detail.view.MovieDetailView
import com.project.asmv.movietesttask.unit.data.movie_details.MovieDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailPresenterImpl @Inject constructor(
    private var movieDetailView: MovieDetailView,
    private var movieDetailInteractor: MovieDetailInteractor
) : MovieDetailPresenter {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun getDetailMovie(id: Long) {
        disposable.clear()
        disposable.add(
            movieDetailInteractor.getPopularMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::result)
        )
    }


    private fun result(movieDetail: MovieDetail) {
        movieDetailView.setupDetail(movieDetail)
    }


    override fun disposble() {
        disposable.dispose()
    }
}