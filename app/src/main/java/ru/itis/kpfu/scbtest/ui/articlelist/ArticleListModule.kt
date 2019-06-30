package ru.itis.kpfu.scbtest.ui.articlelist

import dagger.Module
import dagger.Provides


@Module
class ArticleListModule {

    @Provides
    fun provideArticleListAdapter() = ArticleListAdapter()

    @Provides
    fun provideArticleHolder() = ArticleHolder.getInstance()

    @Provides
    fun provideArticle(articleHolder: ArticleHolder) = articleHolder.article
}