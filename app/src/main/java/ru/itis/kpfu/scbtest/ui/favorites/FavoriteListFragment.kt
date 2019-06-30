package ru.itis.kpfu.scbtest.ui.favorites

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.base.BaseFragment
import ru.itis.kpfu.scbtest.databinding.FragmentFavoritesBinding
import ru.itis.kpfu.scbtest.di.viewmodel.ViewModelFactory
import javax.inject.Inject

class FavoriteListFragment @Inject constructor(): BaseFragment() {

    companion object {
        fun getInstance() = FavoriteListFragment()
    }

    override fun layoutRes() = R.layout.fragment_favorites

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: FavoriteListViewModel

    private lateinit var fragmentBinding: FragmentFavoritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentBinding = binding as FragmentFavoritesBinding
        fragmentBinding.rvFavorites.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        fragmentBinding.rvFavorites.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FavoriteListViewModel::class.java)

        fragmentBinding.viewModel = viewModel
    }
}