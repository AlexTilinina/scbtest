package ru.itis.kpfu.scbtest.model.entity

data class HeadlinesResult(val status: String,
                           val totalResults: Int,
                           val articles: List<Article>)