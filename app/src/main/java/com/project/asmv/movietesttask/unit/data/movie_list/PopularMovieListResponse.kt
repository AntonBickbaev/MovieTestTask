package com.project.asmv.movietesttask.unit.data.movie_list

import com.google.gson.annotations.SerializedName

data class PopularMovieListResponse(
    @SerializedName("page") var page : Int?,
    @SerializedName("total_results") var totalResults : Long?,
    @SerializedName("total_pages") var totalPages : Long?,
    @SerializedName("results") var results : ArrayList<PopularMovie>?
)