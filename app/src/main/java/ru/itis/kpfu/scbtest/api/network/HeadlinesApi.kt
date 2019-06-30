package ru.itis.kpfu.scbtest.api.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.itis.kpfu.scbtest.model.entity.HeadlinesResult

interface HeadlinesApi {

    @GET("top-headlines")
    fun getNewsFromSource(@Query("sources") source: String): Single<HeadlinesResult>
}