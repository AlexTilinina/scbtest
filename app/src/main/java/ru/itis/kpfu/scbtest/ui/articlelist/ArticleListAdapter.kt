package ru.itis.kpfu.scbtest.ui.articlelist

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.databinding.ItemArticleBinding
import ru.itis.kpfu.scbtest.model.entity.Article
import javax.inject.Inject

class ArticleListAdapter @Inject constructor() : RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {

    private lateinit var articleList: List<Article>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemArticleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_article, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount(): Int {
        return if(::articleList.isInitialized) articleList.size else 0
    }

    fun updateArticleList(articleList: List<Article>){
        this.articleList = articleList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemArticleBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = ArticleViewModel()

        fun bind(article: Article){
            viewModel.bind(article)
            binding.article = viewModel
        }
    }
}