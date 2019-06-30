package ru.itis.kpfu.scbtest.api.network

import io.reactivex.Single
import retrofit2.http.GET
import ru.itis.kpfu.scbtest.model.entity.SourcesResult

interface SourcesApi {

    @GET("sources")
    fun getSources(): Single<SourcesResult>
}