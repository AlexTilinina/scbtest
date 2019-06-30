package ru.itis.kpfu.scbtest.ui.article

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import ru.itis.kpfu.scbtest.base.BaseViewModel
import ru.itis.kpfu.scbtest.model.entity.Article
import ru.itis.kpfu.scbtest.model.repository.ArticleRepository
import ru.itis.kpfu.scbtest.model.repository.SourceRepository
import javax.inject.Inject

class ArticleViewModel @Inject constructor(
    val article: Article,
    var articleRepository: ArticleRepository,
    var sourceRepository: SourceRepository
) : BaseViewModel() {

    val source = MutableLiveData<String>()
    val author = MutableLiveData<String>()
    val isFavorite = MutableLiveData<Boolean>()
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val url = MutableLiveData<String>()
    val urlToImage = MutableLiveData<String>()
    val publishedAt = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    fun bind() {
        source.value = article.source.name
        author.value = article.author
        isFavorite.value = article.isFavorite
        title.value = article.url
        description.value = article.description
        url.value = article.url
        urlToImage.value = article.urlToImage
        publishedAt.value = article.publishedAt
        content.value = article.content
    }

    fun onFavoriteClick() {
        if (isFavorite.value == true) {
            articleRepository.delete(article.toArticlePojo())
            isFavorite.value = false
        } else {
            sourceRepository.insert(article.source.toSourcePojo())
            articleRepository.insert(article.toArticlePojo())
            isFavorite.value = true
        }
    }
}