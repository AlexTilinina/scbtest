package ru.itis.kpfu.scbtest.ui.sourcelist

import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import android.view.View
import io.reactivex.disposables.Disposable
import ru.itis.kpfu.scbtest.base.BaseViewModel
import ru.itis.kpfu.scbtest.model.entity.Source
import ru.itis.kpfu.scbtest.api.repository.SourcesRepository


class SourceListViewModel @Inject constructor (var sourcesRepository: SourcesRepository) : BaseViewModel() {

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    @Inject
    lateinit var sourceListAdapter: SourceListAdapter

    private lateinit var subscription: Disposable

    init {
        loadSources()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadSources() {
        subscription = sourcesRepository.getSources()
            .map{it.sources}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveSourceListStart() }
            .doAfterTerminate { onRetrieveSourceListFinish() }
            .subscribe(this::onRetrieveSourceListSuccess)
    }

    private fun onRetrieveSourceListStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveSourceListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveSourceListSuccess(sourceList: List<Source>) {
        sourceListAdapter.updateSourceList(sourceList)
    }
}