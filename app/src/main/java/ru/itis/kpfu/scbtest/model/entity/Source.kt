package ru.itis.kpfu.scbtest.model.entity

import ru.itis.kpfu.scbtest.model.entity.room.SourcePojo

data class Source(
    val id: String,
    val name: String,
    val description: String? = null,
    val url: String? = null,
    val category: String? = null,
    val language: String? = null,
    val country: String? = null
) {
    fun toSourcePojo(): SourcePojo {
        return SourcePojo(id, name)
    }
}