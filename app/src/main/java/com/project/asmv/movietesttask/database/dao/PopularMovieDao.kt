package com.project.asmv.movietesttask.database.dao

import android.arch.persistence.room.*
import com.project.asmv.movietesttask.database.entity.PopularMovieEntity
import io.reactivex.Single

@Dao
interface PopularMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(popularMovieEntity: List<PopularMovieEntity>)

    @Query("SELECT * FROM popular_movie")
    fun getPopularMovies(): Single<List<PopularMovieEntity>>

    @Query("SELECT * FROM popular_movie WHERE  idMovie = :id")
    fun getPopularMovie(id: Long): Single<PopularMovieEntity>


    @Query("DELETE FROM popular_movie")
    fun deleteAll()
}