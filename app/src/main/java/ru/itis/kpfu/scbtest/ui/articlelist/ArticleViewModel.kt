package ru.itis.kpfu.scbtest.ui.articlelist

import android.arch.lifecycle.MutableLiveData
import android.view.View
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.base.BaseActivity
import ru.itis.kpfu.scbtest.model.entity.Article

class ArticleViewModel {
    val author = MutableLiveData<String>()
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    lateinit var article: Article


    fun bind(article: Article){
        author.value = article.author
        title.value = article.url
        description.value = article.description
        this.article = article
    }

    fun openArticle(view: View) {
        ArticleHolder.getInstance().article = this.article
        (view.context as BaseActivity).setFragment(R.id.articleFragment)
    }
}