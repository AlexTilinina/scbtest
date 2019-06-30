package ru.itis.kpfu.scbtest.base

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.itis.kpfu.scbtest.di.DaggerApplicationComponent


class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerApplicationComponent
           .builder()
           .application(this)
           .build()
    }

    /*   override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
           return DaggerApplicationComponent
               .builder()
               .application(this)
               .create(this)
       }*/
}
