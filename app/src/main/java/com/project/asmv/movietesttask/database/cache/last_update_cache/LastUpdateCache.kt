package com.project.asmv.movietesttask.database.cache.last_update_cache

import com.project.asmv.movietesttask.database.entity.LastUpdateEntity
import io.reactivex.Single

interface LastUpdateCache {

    fun insert(lastUpdateEntity: LastUpdateEntity)

    fun getLastTime(): Single<LastUpdateEntity>

    fun deleteAll()
}