package com.project.asmv.movietesttask.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.project.asmv.movietesttask.database.dao.LastUpdateDao
import com.project.asmv.movietesttask.database.dao.PopularMovieDao
import com.project.asmv.movietesttask.database.entity.LastUpdateEntity
import com.project.asmv.movietesttask.database.entity.PopularMovieEntity
import com.project.asmv.movietesttask.database.type_converter.DateConverter
import com.project.asmv.movietesttask.database.type_converter.GenreIdsConverter

@Database(
    entities = [PopularMovieEntity::class, LastUpdateEntity::class]
    , version = 1
    , exportSchema = true
)
@TypeConverters(GenreIdsConverter::class, DateConverter::class)
abstract class DataBase : RoomDatabase() {
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun lastUpdateDao(): LastUpdateDao
}