package ru.itis.kpfu.scbtest.api.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import ru.itis.kpfu.scbtest.util.API_KEY
import ru.itis.kpfu.scbtest.util.API_KEY_PARAM

class ApiKeyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        return chain.proceed(original.newBuilder()
            .url(getUrl(original))
            .build())
    }

    private fun getUrl(request: Request): HttpUrl {
        return request.url().newBuilder()
            .addQueryParameter(API_KEY_PARAM, API_KEY)
            .build()
    }
}