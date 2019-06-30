package ru.itis.kpfu.scbtest.api.repository

import io.reactivex.Single
import ru.itis.kpfu.scbtest.api.network.SourcesApi
import ru.itis.kpfu.scbtest.model.entity.SourcesResult
import javax.inject.Inject

class SourcesRepository @Inject constructor(private val sourcesApi: SourcesApi) {

    fun getSources(): Single<SourcesResult> = sourcesApi.getSources()
}