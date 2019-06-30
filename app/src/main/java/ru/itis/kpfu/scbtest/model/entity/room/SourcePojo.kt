package ru.itis.kpfu.scbtest.model.entity.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "sources")
data class SourcePojo(
    @PrimaryKey
    val source_id: String,
    val name: String
)