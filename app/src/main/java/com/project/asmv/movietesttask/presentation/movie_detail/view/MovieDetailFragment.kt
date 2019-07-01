package com.project.asmv.movietesttask.presentation.movie_detail.view

import android.content.Context
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.project.asmv.movietesttask.R
import com.project.asmv.movietesttask.unit.base.BaseFragment
import com.project.asmv.movietesttask.unit.data.movie_details.MovieDetail
import com.project.asmv.movietesttask.presentation.MovieFragmentListener
import com.project.asmv.movietesttask.presentation.movie_detail.presenter.MovieDetailPresenter
import kotlinx.android.synthetic.main.adapter_movie_list.imageCover
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import javax.inject.Inject

class MovieDetailFragment : BaseFragment(), MovieDetailView {

    companion object {

        const val MOVIE_ID = "MOVIE_ID"

        fun newInstance(id: Long?): MovieDetailFragment {
            val bundle = Bundle()
            bundle.putLong(MOVIE_ID, id ?: 0L)
            val fragment = MovieDetailFragment()
            fragment.arguments = bundle
            return fragment

        }
    }

    private var movieFragmentListener: MovieFragmentListener? = null

    @Inject
    lateinit var movieDetailPresenter: MovieDetailPresenter

    override fun getLayoutId(): Int = R.layout.fragment_movie_detail

    override fun isBack(): Boolean = true

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        movieFragmentListener = context as MovieFragmentListener
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id: Long = arguments?.getLong(MOVIE_ID, 0L) ?: 0L
        movieDetailPresenter.getDetailMovie(id)

    }

    override fun setupDetail(movieDetail: MovieDetail) {
        setupTitle(movieDetail.title ?: "")
        context?.let {
            Glide.with(it)
                .load(movieDetail.posterPath)
                .into(imageCover)
        }
        description?.text = movieDetail.overview

    }

    override fun onDestroyView() {
        super.onDestroyView()
        movieFragmentListener = null
        movieDetailPresenter.disposble()
    }

}