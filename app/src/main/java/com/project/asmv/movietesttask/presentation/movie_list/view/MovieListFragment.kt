package com.project.asmv.movietesttask.presentation.movie_list.view

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.project.asmv.movietesttask.R
import com.project.asmv.movietesttask.unit.base.BaseFragment
import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieItem
import com.project.asmv.movietesttask.presentation.MovieFragmentListener
import com.project.asmv.movietesttask.presentation.movie_list.presenter.MovieListPresenter
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

class MovieListFragment : BaseFragment(), MovieListView {

    companion object {

        fun newInstance(): MovieListFragment {
            return MovieListFragment()
        }
    }


    @Inject
    lateinit var movieListPresenter: MovieListPresenter

    private var movieFragmentListener: MovieFragmentListener? = null
    private var movieListAdapter: MovieListAdapter? = null

    override fun getLayoutId(): Int = R.layout.fragment_movie_list

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        movieFragmentListener = context as MovieFragmentListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTitle(R.string.title_list)
        loadListFilm()
        context?.let {
            movieListAdapter =
                MovieListAdapter(it) { popularMovieItem ->
                    movieFragmentListener?.openMovieDetail(
                        popularMovieItem.id
                    )
                }
            movieList?.layoutManager = LinearLayoutManager(it)
            movieList?.adapter = movieListAdapter
        }
        swipeRefresh.setOnRefreshListener {
            loadListFilm()
        }
    }

    private fun loadListFilm() {
        swipeRefresh?.isRefreshing = true
        movieListPresenter.getMovieList()
    }


    override fun completableList(popularMovieItemList: ArrayList<PopularMovieItem>) {
        movieListAdapter?.addMovieList(popularMovieItemList)
        swipeRefresh?.isRefreshing = false
    }

    override fun errorSnackBar(text: Int) {
        swipeRefresh?.isRefreshing = false
        view?.let {
            val snackbar = Snackbar
                .make(it, text, Snackbar.LENGTH_LONG)
                .setAction(R.string.btn_retry) { loadListFilm() }
            snackbar.show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        movieFragmentListener = null
        movieListPresenter.disposble()
    }

}