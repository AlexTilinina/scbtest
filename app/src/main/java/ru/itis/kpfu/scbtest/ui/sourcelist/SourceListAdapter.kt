package ru.itis.kpfu.scbtest.ui.sourcelist

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.databinding.ItemSourceBinding
import ru.itis.kpfu.scbtest.model.entity.Source
import javax.inject.Inject


class SourceListAdapter @Inject constructor() : RecyclerView.Adapter<SourceListAdapter.ViewHolder>() {

    private lateinit var sourceList: List<Source>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemSourceBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_source, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sourceList[position])
    }

    override fun getItemCount(): Int {
        return if(::sourceList.isInitialized) sourceList.size else 0
    }

    fun updateSourceList(sourceList: List<Source>){
        this.sourceList = sourceList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemSourceBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = SourceViewModel()

        fun bind(source: Source){
            viewModel.bind(source)
            binding.source = viewModel
        }
    }
}