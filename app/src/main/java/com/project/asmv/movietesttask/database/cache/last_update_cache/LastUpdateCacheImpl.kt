package com.project.asmv.movietesttask.database.cache.last_update_cache

import com.project.asmv.movietesttask.database.DataBase
import com.project.asmv.movietesttask.database.entity.LastUpdateEntity
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class LastUpdateCacheImpl @Inject constructor(private var database: DataBase) :
    LastUpdateCache {
    override fun insert(lastUpdateEntity: LastUpdateEntity) {
        database.lastUpdateDao().insert(lastUpdateEntity)
    }

    override fun getLastTime(): Single<LastUpdateEntity> {
        return database.lastUpdateDao().getLastTime(Date())
    }

    override fun deleteAll() {
        database.lastUpdateDao().deleteAll()
    }

}