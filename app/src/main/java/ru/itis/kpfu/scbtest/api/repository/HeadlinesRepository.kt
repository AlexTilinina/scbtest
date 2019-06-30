package ru.itis.kpfu.scbtest.api.repository

import ru.itis.kpfu.scbtest.api.network.HeadlinesApi
import javax.inject.Inject

class HeadlinesRepository @Inject constructor(val headlinesApi: HeadlinesApi) {

    fun getNewsFromSource(source: String) = headlinesApi.getNewsFromSource(source)
}