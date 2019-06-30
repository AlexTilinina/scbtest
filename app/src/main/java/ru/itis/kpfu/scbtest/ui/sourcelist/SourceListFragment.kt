package ru.itis.kpfu.scbtest.ui.sourcelist


import ru.itis.kpfu.scbtest.base.BaseFragment
import ru.itis.kpfu.scbtest.di.viewmodel.ViewModelFactory
import javax.inject.Inject
import android.support.v7.widget.LinearLayoutManager
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.databinding.FragmentSourcesBinding
import ru.itis.kpfu.scbtest.ui.MainActivity


class SourceListFragment @Inject constructor() : BaseFragment() {

    companion object {
        fun getInstance() = SourceListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: SourceListViewModel

    private lateinit var fragmentBinding: FragmentSourcesBinding

    override fun layoutRes() = R.layout.fragment_sources

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentBinding = binding as FragmentSourcesBinding
        fragmentBinding.rvSources.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        fragmentBinding.rvSources.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SourceListViewModel::class.java)

        fragmentBinding.viewModel = viewModel
    }
}