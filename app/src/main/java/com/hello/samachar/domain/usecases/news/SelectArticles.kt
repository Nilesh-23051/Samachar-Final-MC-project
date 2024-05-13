package com.hello.samachar.domain.usecases.news

import com.hello.samachar.data.local.NewsDao
import com.hello.samachar.domain.model.Article
import com.hello.samachar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {

   operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }

}