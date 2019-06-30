package ru.itis.kpfu.scbtest.di.view

import dagger.Module
import ru.itis.kpfu.scbtest.ui.MainActivity
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainFragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}