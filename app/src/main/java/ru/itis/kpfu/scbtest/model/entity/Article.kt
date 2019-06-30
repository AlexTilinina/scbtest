package ru.itis.kpfu.scbtest.model.entity

import ru.itis.kpfu.scbtest.model.entity.room.ArticlePojo
import ru.itis.kpfu.scbtest.model.entity.room.SourcePojo


data class Article(
    val articleId: Long?,
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
    var isFavorite: Boolean = false
) {

    constructor(article: ArticlePojo, source: SourcePojo) :
            this(
                article.articleId,
                Source(source.source_id, source.name),
                article.author,
                article.title,
                article.description,
                article.url,
                article.urlToImage,
                article.publishedAt,
                article.content,
                article.isFavorite
            )

    fun toArticlePojo(): ArticlePojo {
        val id = articleId ?: 0
        return ArticlePojo(
            id,
            source.id,
            author,
            title,
            description,
            url,
            urlToImage,
            publishedAt,
            content,
            isFavorite)
    }
}