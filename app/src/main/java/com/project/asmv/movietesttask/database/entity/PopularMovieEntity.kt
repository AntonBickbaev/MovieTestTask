package com.project.asmv.movietesttask.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "popular_movie", indices = [Index(value = ["idMovie"], unique = true)])
data class PopularMovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_popular_movie")
    var id: Int? = null,
    @ColumnInfo(name = "voteCount")
    var voteCount: Long?,
    @ColumnInfo(name = "idMovie")
    var idMovie: Long?,
    @ColumnInfo(name = "video")
    var video: Boolean?,
    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double?,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "popularity")
    var popularity: Double?,
    @ColumnInfo(name = "posterPath")
    var posterPath: String?,
    @ColumnInfo(name = "original_language")
    var originalLanguage: String?,
    @ColumnInfo(name = "original_title")
    var originalTitle: String?,
    @ColumnInfo(name = "genre_ids")
    var genreIds: List<Int>?,
    @ColumnInfo(name = "backdrop_path")
    var backdropPath: String?,
    @ColumnInfo(name = "adult")
    var adult: Boolean?,
    @ColumnInfo(name = "overview")
    var overview: String?,
    @ColumnInfo(name = "releaseDate")
    var releaseDate: String?

)