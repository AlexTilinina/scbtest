package ru.itis.kpfu.scbtest.ui.articlelist

import ru.itis.kpfu.scbtest.model.entity.Article
import javax.inject.Inject

class ArticleHolder @Inject constructor(){

    companion object {
        private val articleHolder = ArticleHolder()

        fun getInstance() = articleHolder
    }

    lateinit var article: Article
}