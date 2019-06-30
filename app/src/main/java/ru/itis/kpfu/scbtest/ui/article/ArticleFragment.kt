package ru.itis.kpfu.scbtest.ui.article

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.base.BaseFragment
import ru.itis.kpfu.scbtest.databinding.FragmentArticleBinding
import ru.itis.kpfu.scbtest.di.viewmodel.ViewModelFactory
import ru.itis.kpfu.scbtest.model.entity.Article
import javax.inject.Inject

class ArticleFragment @Inject constructor(): BaseFragment() {

    companion object {
        fun getInstance() = ArticleFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

 /*   @Inject
    lateinit var article: Article*/

    lateinit var viewModel: ArticleViewModel

    private lateinit var fragmentBinding: FragmentArticleBinding

    override fun layoutRes() = R.layout.fragment_article

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentBinding = binding as FragmentArticleBinding

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ArticleViewModel::class.java)

        viewModel.bind()

        fragmentBinding.article = viewModel
    }
}