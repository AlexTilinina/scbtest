package ru.itis.kpfu.scbtest.model.repository

import android.arch.lifecycle.LiveData
import ru.itis.kpfu.scbtest.model.dao.ArticleDao
import ru.itis.kpfu.scbtest.model.entity.room.ArticlePojo
import ru.itis.kpfu.scbtest.model.entity.room.ArticleWithSource

class ArticleRepository(private val articleDao: ArticleDao) {

    fun insert(obj: ArticlePojo) = articleDao.insert(obj)

    fun delete(obj: ArticlePojo) = articleDao.delete(obj)

    fun getAll(): LiveData<List<ArticleWithSource>> = articleDao.getAll()
}