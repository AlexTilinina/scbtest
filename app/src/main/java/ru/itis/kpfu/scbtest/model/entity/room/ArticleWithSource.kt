package ru.itis.kpfu.scbtest.model.entity.room

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import ru.itis.kpfu.scbtest.model.entity.Article


class ArticleWithSource {

    @Embedded
    lateinit var articlePojo: ArticlePojo

    @Embedded
    lateinit var sourcePojo: SourcePojo

    fun getArticle(): Article {
        return Article(articlePojo, sourcePojo)
    }
}