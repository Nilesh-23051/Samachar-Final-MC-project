package com.hello.samachar.domain.usecases.news

import androidx.paging.PagingData
import com.hello.samachar.domain.model.Article
import com.hello.samachar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources:List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources)

    }
}