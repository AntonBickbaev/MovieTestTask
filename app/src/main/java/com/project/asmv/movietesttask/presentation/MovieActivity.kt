package com.project.asmv.movietesttask.presentation

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.project.asmv.movietesttask.R
import com.project.asmv.movietesttask.presentation.movie_detail.MovieDetailFragment
import com.project.asmv.movietesttask.presentation.movie_list.MovieListFragment
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main.*

interface MovieFragmentListener {
    fun openMovieList()
    fun openMovieDetail(id: Long?)

}

class MovieActivity : DaggerAppCompatActivity(), MovieFragmentListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        openMovieList()
    }

    override fun openMovieList() {
        replaceFragment(MovieListFragment.newInstance())
    }

    override fun openMovieDetail(id: Long?) {
        replaceFragment(MovieDetailFragment.newInstance(id))
    }

    private fun replaceFragment(fragment: DaggerFragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        if (fragment is MovieListFragment) {
            transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        } else {
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
        }
        transaction.replace(R.id.container, fragment, fragment::class.java.name)
        transaction.commit()



    }

    override fun onBackPressed() {
        isBack()
    }

    private fun isBack() {
        val fragment = supportFragmentManager.findFragmentByTag(MovieDetailFragment::class.java.name)
        if (fragment != null) {
            if (fragment.isVisible) {
                openMovieList()
            } else {
                finish()
            }
        } else {
            finish()
        }
    }
}
