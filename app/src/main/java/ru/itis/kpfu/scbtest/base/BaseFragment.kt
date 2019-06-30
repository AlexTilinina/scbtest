package ru.itis.kpfu.scbtest.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import dagger.android.support.DaggerFragment


abstract class BaseFragment : DaggerFragment() {

    protected lateinit var binding : ViewDataBinding

    protected abstract fun layoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes(), container, false)
        return binding.root
    }
}
