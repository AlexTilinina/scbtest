package ru.itis.kpfu.scbtest.model.entity.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(
    tableName = "articles",
    foreignKeys = [ForeignKey(
        entity = SourcePojo::class,
        parentColumns = ["source_id"],
        childColumns = ["sourceId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ArticlePojo(
    @PrimaryKey(autoGenerate = true)
    val articleId: Long,
    @ColumnInfo(index = true)
    val sourceId: String,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
    var isFavorite: Boolean = false
)