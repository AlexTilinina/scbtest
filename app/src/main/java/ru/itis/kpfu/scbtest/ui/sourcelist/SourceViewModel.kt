package ru.itis.kpfu.scbtest.ui.sourcelist

import android.arch.lifecycle.MutableLiveData
import android.view.View
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.base.BaseActivity
import ru.itis.kpfu.scbtest.model.entity.Source

class SourceViewModel {
    val name = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val url = MutableLiveData<String>()
    lateinit var sourceId: String

    fun bind(source: Source){
        name.value = source.name
        description.value = source.description
        url.value = source.url
        this.sourceId = source.id
    }

    fun openArticleList(view: View) {
        SourceIdHolder.getInstance().sourceId = sourceId
        (view.context as BaseActivity).setFragment(R.id.articleListFragment)
    }
}