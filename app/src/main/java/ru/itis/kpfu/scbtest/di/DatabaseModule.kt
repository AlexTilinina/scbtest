package ru.itis.kpfu.scbtest.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.itis.kpfu.scbtest.model.FavoritesRoomDatabase
import ru.itis.kpfu.scbtest.model.repository.ArticleRepository
import ru.itis.kpfu.scbtest.model.repository.SourceRepository

@Module
class DatabaseModule {

    @Provides
    fun provideArticleRepository(context: Context) = ArticleRepository(FavoritesRoomDatabase.getDatabase(context).articleDao())

    @Provides
    fun provideSourceRepository(context: Context) = SourceRepository(FavoritesRoomDatabase.getDatabase(context).sourceDao())
}