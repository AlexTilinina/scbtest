package ru.itis.kpfu.scbtest.di.view

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.itis.kpfu.scbtest.ui.article.ArticleFragment
import ru.itis.kpfu.scbtest.ui.articlelist.ArticleListFragment
import ru.itis.kpfu.scbtest.ui.favorites.FavoriteListFragment
import ru.itis.kpfu.scbtest.ui.sourcelist.SourceListFragment


@Module
abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun provideSourceListFragment(): SourceListFragment

    @ContributesAndroidInjector
    abstract fun provideArticleListFragment(): ArticleListFragment

    @ContributesAndroidInjector
    abstract fun provideArticleFragment(): ArticleFragment

    @ContributesAndroidInjector
    abstract fun provideFavoriteListFragment(): FavoriteListFragment
}