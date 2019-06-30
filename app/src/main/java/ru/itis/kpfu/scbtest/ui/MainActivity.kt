package ru.itis.kpfu.scbtest.ui

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import ru.itis.kpfu.scbtest.R
import ru.itis.kpfu.scbtest.base.BaseActivity
import ru.itis.kpfu.scbtest.base.BaseFragment
import ru.itis.kpfu.scbtest.ui.sourcelist.SourceListFragment
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var sourceListFragment: SourceListFragment

    private var favorites = false

    override var fragmentBase: BaseFragment
        get() = sourceListFragment
        set(value) {}

    override fun layoutRes() = R.layout.activity_main

    override fun getNavHostFragment() = R.id.nav_host_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_favorites_menu, menu)
        return true
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_favorites -> {
                if (favorites) {
                    item.icon = resources.getDrawable(R.drawable.ic_favorite_empty, null)
                    setFragment(R.id.sourceListFragment)
                    //setFragment(SourceListFragment.getInstance(), false)
                } else {
                    item.icon = resources.getDrawable(R.drawable.ic_favorite_full, null)
                    setFragment(R.id.favoriteListFragment)
                   // setFragment(FavoriteListFragment.getInstance(), false)
                }
                favorites = !favorites
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
