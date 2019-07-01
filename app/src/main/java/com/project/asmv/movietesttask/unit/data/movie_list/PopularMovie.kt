package com.project.asmv.movietesttask.unit.data.movie_list

import com.google.gson.annotations.SerializedName

data class PopularMovie(
    @SerializedName("vote_count") var voteCount: Long?,
    @SerializedName("id") var id: Long?,
    @SerializedName("video") var video: Boolean?,
    @SerializedName("vote_average") var voteAverage: Double?,
    @SerializedName("title") var title: String?,
    @SerializedName("popularity") var popularity: Double?,
    @SerializedName("poster_path") var posterPath: String?,
    @SerializedName("original_language") var originalLanguage: String?,
    @SerializedName("original_title") var originalTitle: String?,
    @SerializedName("genre_ids") var genreIds: List<Int>?,
    @SerializedName("backdrop_path") var backdropPath: String?,
    @SerializedName("adult") var adult: Boolean?,
    @SerializedName("overview") var overview: String?,
    @SerializedName("release_date") var releaseDate: String?
)