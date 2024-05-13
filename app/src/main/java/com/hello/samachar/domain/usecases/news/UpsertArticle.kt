package com.hello.samachar.domain.usecases.news

import com.hello.samachar.data.local.NewsDao
import com.hello.samachar.domain.model.Article
import com.hello.samachar.domain.repository.NewsRepository
import javax.inject.Inject

class UpsertArticle @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticle(article = article)
    }

}