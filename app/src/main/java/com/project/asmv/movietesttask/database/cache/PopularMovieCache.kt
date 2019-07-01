package com.project.asmv.movietesttask.database.cache

import com.project.asmv.movietesttask.database.DataBase
import com.project.asmv.movietesttask.database.entity.LastUpdateEntity
import com.project.asmv.movietesttask.database.entity.PopularMovieEntity
import com.project.asmv.movietesttask.unit.Units.createDateTo
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

interface PopularMovieCache {

    fun insert(popularMovieEntity: List<PopularMovieEntity>)

    fun getPopularMovies(): Single<List<PopularMovieEntity>>

    fun getPopularMovie(id: Long): Single<PopularMovieEntity>

    fun deleteAll()

}

class PopularMovieCacheImpl @Inject constructor(
    private var database: DataBase,
    private var lastUpdateCache: LastUpdateCache
) : PopularMovieCache {


    override fun insert(popularMovieEntity: List<PopularMovieEntity>) {
        clearOldEntity()
        val dateFrom = Date()
        val dateTo = createDateTo(dateFrom.time)
        lastUpdateCache.insert(LastUpdateEntity(dateFrom = dateFrom, dateTo = dateTo))
        database.popularMovieDao().insert(popularMovieEntity)


    }

    override fun getPopularMovies(): Single<List<PopularMovieEntity>> {
        return database.popularMovieDao().getPopularMovies()
    }

    override fun getPopularMovie(id: Long): Single<PopularMovieEntity> {
        return database.popularMovieDao().getPopularMovie(id)
    }


    override fun deleteAll() {
        database.popularMovieDao().deleteAll()
    }

    private fun clearOldEntity() {
        deleteAll()
        database.lastUpdateDao().deleteAll()
    }

}