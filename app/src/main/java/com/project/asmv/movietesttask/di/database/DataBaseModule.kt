package com.project.asmv.movietesttask.di.database

import android.app.Application
import android.arch.persistence.room.Room
import com.project.asmv.movietesttask.database.DataBase
import com.project.asmv.movietesttask.database.cache.LastUpdateCache
import com.project.asmv.movietesttask.database.cache.LastUpdateCacheImpl
import com.project.asmv.movietesttask.database.cache.PopularMovieCache
import com.project.asmv.movietesttask.database.cache.PopularMovieCacheImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    companion object {
        const val DATA_BASE_NAME = "movie_test_task.db"
    }

    @Provides
    @Singleton
    fun provideDataBase(app: Application): DataBase {
        return Room
            .databaseBuilder(app, DataBase::class.java, DATA_BASE_NAME)
            // .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideLastUpdateCache(dataBase: DataBase): LastUpdateCache {
        return LastUpdateCacheImpl(dataBase)
    }

    @Provides
    @Singleton
    fun providePopularMovieCache(dataBase: DataBase,lastUpdateCache: LastUpdateCache): PopularMovieCache {
        return PopularMovieCacheImpl(dataBase,lastUpdateCache)
    }

}