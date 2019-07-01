package com.project.asmv.movietesttask.database.type_converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson

class GenreIdsConverter {

    @TypeConverter
    fun fromGenereIds(genreIds: List<Int>): String {
        return Gson().toJson(genreIds)
    }

    @TypeConverter
    fun toGenereIds(genreIds: String): List<Int> {
        val objects = Gson().fromJson(genreIds, Array<Int>::class.java) as Array<Int>
        return objects.toList()
    }

}