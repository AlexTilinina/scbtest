package ru.itis.kpfu.scbtest.di.viewmodel

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import android.arch.lifecycle.ViewModel
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.kpfu.scbtest.ui.article.ArticleViewModel
import ru.itis.kpfu.scbtest.ui.articlelist.ArticleListViewModel
import ru.itis.kpfu.scbtest.ui.favorites.FavoriteListViewModel
import ru.itis.kpfu.scbtest.ui.sourcelist.SourceListViewModel


@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SourceListViewModel::class)
    fun bindSourceListViewModel(sourceListViewModel: SourceListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticleListViewModel::class)
    fun bindarticleListViewModel(articleListViewModel: ArticleListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel::class)
    fun bindArticleViewModel(articleViewModel: ArticleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteListViewModel::class)
    fun bindfavoriteListViewModel(favoriteListViewModel: FavoriteListViewModel): ViewModel

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
