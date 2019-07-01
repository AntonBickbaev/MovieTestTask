package com.project.asmv.movietesttask.database.cache

import com.project.asmv.movietesttask.database.DataBase
import com.project.asmv.movietesttask.database.entity.LastUpdateEntity
import com.project.asmv.movietesttask.unit.Units.createDateTo
import io.reactivex.Single
import java.util.*
import javax.inject.Inject



interface LastUpdateCache {

    fun insert(lastUpdateEntity: LastUpdateEntity)

    fun getLastTime(): Single<LastUpdateEntity>

    fun deleteAll()
}

class LastUpdateCacheImpl @Inject constructor(private var database: DataBase) : LastUpdateCache {
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