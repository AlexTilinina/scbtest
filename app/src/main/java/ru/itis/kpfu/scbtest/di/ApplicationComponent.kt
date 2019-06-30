package ru.itis.kpfu.scbtest.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.itis.kpfu.scbtest.base.BaseApplication
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.itis.kpfu.scbtest.di.view.ActivityBindingModule
import ru.itis.kpfu.scbtest.di.view.MainFragmentBindingModule
import ru.itis.kpfu.scbtest.di.viewmodel.ViewModelModule
import ru.itis.kpfu.scbtest.ui.articlelist.ArticleListModule
import ru.itis.kpfu.scbtest.ui.sourcelist.SourceListModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ContextModule::class,
        SourceListModule::class,
        ActivityBindingModule::class,
        MainFragmentBindingModule::class,
        ViewModelModule::class,
        ArticleListModule::class,
        DatabaseModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    override fun inject(application: BaseApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent

    }
}