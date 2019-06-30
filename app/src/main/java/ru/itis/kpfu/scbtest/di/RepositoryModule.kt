package ru.itis.kpfu.scbtest.di

import dagger.Module
import dagger.Provides
import ru.itis.kpfu.scbtest.api.network.HeadlinesApi
import ru.itis.kpfu.scbtest.api.network.SourcesApi
import ru.itis.kpfu.scbtest.api.repository.HeadlinesRepository
import ru.itis.kpfu.scbtest.api.repository.SourcesRepository

@Module
class RepositoryModule {

    @Provides
    fun provideSourcesRepository(sourcesApi: SourcesApi) = SourcesRepository(sourcesApi)

    @Provides
    fun provideHeadlinesRepository(headlinesApi: HeadlinesApi) = HeadlinesRepository(headlinesApi)
}