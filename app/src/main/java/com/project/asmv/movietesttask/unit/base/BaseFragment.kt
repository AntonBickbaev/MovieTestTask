package com.project.asmv.movietesttask.unit.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.project.asmv.movietesttask.R
import com.project.asmv.movietesttask.presentation.MovieActivity
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    abstract fun getLayoutId(): Int


    open fun isBack(): Boolean = false

    private var toolBar: Toolbar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBar = (activity as MovieActivity).findViewById(R.id.toolbar)
        if (isBack()) {
            arrowBack()
        } else {
            defaultToolbar()
        }
    }

    open fun setupTitle(title: Int) {
        toolBar?.post {
            toolBar?.setTitle(title)
        }
    }

    open fun setupTitle(title: String) {
        toolBar?.post {
            toolBar?.title = title
        }
    }

    private fun defaultToolbar() {
        (activity as MovieActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MovieActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

    }

    private fun arrowBack() {
        (activity as MovieActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MovieActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> (activity as MovieActivity).onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }


}