package com.project.asmv.movietesttask.presentation.movie_list.presenter

import android.content.Context
import com.project.asmv.movietesttask.domain.movie_list.PopularMovieInteractor
import com.project.asmv.movietesttask.presentation.movie_list.view.MovieListView
import com.project.asmv.movietesttask.unit.data.movie_list.MovieInfo
import com.project.asmv.movietesttask.unit.error.ErrorHandler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieListPresenterImpl @Inject constructor(
    private var movieListView: MovieListView,
    private var movieInteractor: PopularMovieInteractor,
    private var handler: ErrorHandler
) : MovieListPresenter {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun getMovieList() {
        disposable.clear()
        disposable.add(
            movieInteractor.getMovieList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::result, this::error)
        )

    }

    override fun disposble() {
        disposable.dispose()
    }

    private fun result(movieInfo: MovieInfo) {
        movieListView.completableList(movieInfo.popularMovieItem)
        if (movieInfo.isNetworkError) {
            error(movieInfo)
        }
    }

    private fun error(exception: Throwable?) {
        exception?.let {
            movieListView.errorSnackBar(handler.getError(it))
        }
    }


}