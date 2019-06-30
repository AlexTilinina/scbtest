package ru.itis.kpfu.scbtest.ui.favorites

import io.reactivex.Observable
import ru.itis.kpfu.scbtest.base.BaseViewModel
import ru.itis.kpfu.scbtest.model.repository.ArticleRepository
import javax.inject.Inject

class FavoriteListViewModel @Inject constructor(var articleRepository: ArticleRepository): BaseViewModel() {

    @Inject
    lateinit var favoriteListAdapter: FavoriteListAdapter

    init {
        getFavorites()
    }

    private fun getFavorites() {
        val favorites = articleRepository.getAll().value
        if (favorites?.isNotEmpty() == true) {
            Observable
                .fromIterable(favorites)
                .map { it.getArticle() }
                .toList()
                .subscribe(favoriteListAdapter::updateFavoriteList)
                .dispose()
        }
    }
}