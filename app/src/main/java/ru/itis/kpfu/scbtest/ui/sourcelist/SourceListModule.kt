package ru.itis.kpfu.scbtest.ui.sourcelist

import dagger.Module
import dagger.Provides

@Module
class SourceListModule {

    @Provides
    fun provideSourceListAdapter() = SourceListAdapter()

    @Provides
    fun provideSourceIdHolder() = SourceIdHolder.getInstance()

    @Provides
    fun provideSource(sourceIdHolder: SourceIdHolder) = sourceIdHolder.sourceId
}