package ru.itis.kpfu.scbtest.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.itis.kpfu.scbtest.api.network.ApiKeyInterceptor
import ru.itis.kpfu.scbtest.api.network.HeadlinesApi
import ru.itis.kpfu.scbtest.api.network.SourcesApi
import ru.itis.kpfu.scbtest.util.BASE_URL
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideSourcesApi(retrofit: Retrofit) = retrofit.create(SourcesApi::class.java)

    @Singleton
    @Provides
    internal fun provideHeadlinesApi(retrofit: Retrofit) = retrofit.create(HeadlinesApi::class.java)

    @Singleton
    @Provides
    internal fun provideRetrofitInterface(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(ApiKeyInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
