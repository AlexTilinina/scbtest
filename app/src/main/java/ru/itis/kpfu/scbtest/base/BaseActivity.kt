package ru.itis.kpfu.scbtest.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity : DaggerAppCompatActivity() {

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun getNavHostFragment(): Int

    protected lateinit var navController: NavController

    abstract var fragmentBase: BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        navController = Navigation.findNavController(this, getNavHostFragment())

    }

    fun setFragment(fragment: Int) {
        navController.navigate(fragment)
    }
}
