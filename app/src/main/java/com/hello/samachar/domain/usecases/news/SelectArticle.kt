package com.hello.samachar.domain.usecases.news

import com.hello.samachar.data.local.NewsDao
import com.hello.samachar.domain.model.Article
import com.hello.samachar.domain.repository.NewsRepository

class SelectArticle (
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String):Article?{
        return newsRepository.selectArticle(url)
    }

}