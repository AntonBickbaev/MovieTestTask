package com.project.asmv.movietesttask.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "last_update", indices = [Index(value = ["id_last_update"], unique = true)])
data class LastUpdateEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_last_update")
    var id: Int? = null,
    @ColumnInfo(name = "date_from")
    var dateFrom: Date?,
    @ColumnInfo(name = "date_to")
    var dateTo: Date?

)