package ru.itis.kpfu.scbtest.ui.articlelist

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.base.BaseFragment
import ru.itis.kpfu.scbtest.databinding.FragmentArticleListBinding
import ru.itis.kpfu.scbtest.di.viewmodel.ViewModelFactory
import javax.inject.Inject

class ArticleListFragment @Inject constructor() : BaseFragment() {

    companion object {

        fun getInstance() = ArticleListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: ArticleListViewModel

    private lateinit var fragmentBinding: FragmentArticleListBinding

    override fun layoutRes() = R.layout.fragment_article_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentBinding = binding as FragmentArticleListBinding
        fragmentBinding.rvNews.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        fragmentBinding.rvNews.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ArticleListViewModel::class.java)

        fragmentBinding.viewModel = viewModel
    }
}