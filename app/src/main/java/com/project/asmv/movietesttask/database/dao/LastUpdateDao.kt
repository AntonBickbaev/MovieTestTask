package com.project.asmv.movietesttask.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.project.asmv.movietesttask.database.entity.LastUpdateEntity
import io.reactivex.Single
import java.util.*

@Dao
interface LastUpdateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(lastUpdateEntity: LastUpdateEntity)

    @Query("SELECT * FROM last_update WHERE :currentDate BETWEEN date_from AND date_to ")
    fun getLastTime(currentDate : Date): Single<LastUpdateEntity>


    @Query("DELETE FROM last_update")
    fun deleteAll()
}