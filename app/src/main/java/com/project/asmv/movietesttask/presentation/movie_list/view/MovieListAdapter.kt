package com.project.asmv.movietesttask.presentation.movie_list.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.project.asmv.movietesttask.R
import com.project.asmv.movietesttask.unit.data.movie_list.PopularMovieItem
import kotlinx.android.synthetic.main.adapter_movie_list.view.*

class MovieListAdapter(
    private val context: Context,
    private val onClickListener: (popularMovieItem: PopularMovieItem) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<PopularMovieItem> = arrayListOf()

    fun addMovieList(popularMovieItemList: ArrayList<PopularMovieItem>) {
        items.addAll(popularMovieItemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.adapter_movie_list, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val popularMovieItem = items[position]
        (viewHolder as MovieViewHolder).bind(popularMovieItem, position)
    }

    inner class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(popularMovieItem: PopularMovieItem, position: Int) {
            view.apply {
                title.text = popularMovieItem.title
                Glide.with(context)
                    .load(popularMovieItem.posterPath)
                    .into(imageCover)
            }
            view.setOnClickListener { onClickListener(popularMovieItem) }

        }

    }

}