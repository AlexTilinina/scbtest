package ru.itis.kpfu.scbtest.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import ru.itis.kpfu.scbtest.model.entity.room.ArticlePojo
import ru.itis.kpfu.scbtest.model.entity.room.ArticleWithSource

@Dao
interface ArticleDao {

    @Insert
    fun insert(article: ArticlePojo)

    @Delete
    fun delete(article: ArticlePojo)

    @Query("SELECT * FROM articles, sources WHERE articles.sourceId = sources.source_id")
    fun getAll() : LiveData<List<ArticleWithSource>>
}