package com.project.asmv.movietesttask.presentation.movie_list.presenter

import com.project.asmv.movietesttask.R
import com.project.asmv.movietesttask.unit.base.BaseView
import com.project.asmv.movietesttask.unit.data.movie_list.MovieInfo
import com.project.asmv.movietesttask.domain.movie_list.PopularMovieInteractor
import com.project.asmv.movietesttask.presentation.movie_list.view.MovieListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.net.UnknownHostException
import javax.inject.Inject

class MovieListPresenterImpl @Inject constructor(
    private var movieListView: MovieListView,
    private var movieInteractor: PopularMovieInteractor
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
        if (movieInfo.isError) {
            error(movieInfo.throwable)
        }
    }

    private fun error(exception: Throwable?) {
        exception?.let {
            if (it is UnknownHostException) {
                movieListView.errorSnackBar(R.string.unknown_host_exception)
            } else {
                movieListView.errorSnackBar(R.string.unknown_exception)
            }
        }
    }


}