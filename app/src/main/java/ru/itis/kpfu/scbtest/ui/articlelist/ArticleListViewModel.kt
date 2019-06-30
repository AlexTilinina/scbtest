package ru.itis.kpfu.scbtest.ui.articlelist

import android.arch.lifecycle.MutableLiveData
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.base.BaseViewModel
import ru.itis.kpfu.scbtest.model.entity.Article
import ru.itis.kpfu.scbtest.api.repository.HeadlinesRepository
import javax.inject.Inject

class ArticleListViewModel @Inject constructor (val headlinesRepository: HeadlinesRepository, val source: String): BaseViewModel() {

    val errorMessage: MutableLiveData<Int> = MutableLiveData()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    @Inject
    lateinit var articleListAdapter: ArticleListAdapter

    private lateinit var subscription: Disposable

    init {
        loadArticles()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadArticles() {
        subscription = headlinesRepository.getNewsFromSource(source)
            .map{it.articles}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveArticleListStart() }
            .doAfterTerminate { onRetrieveArticleListFinish() }
            .subscribe(
                { onRetrieveArticleListSuccess(it) },
                { onRetrieveArticleListError() }
            )
    }

    private fun onRetrieveArticleListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveArticleListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveArticleListSuccess(articleList: List<Article>) {
        articleListAdapter.updateArticleList(articleList)
    }

    private fun onRetrieveArticleListError() {
        errorMessage.value = R.string.error
    }
}