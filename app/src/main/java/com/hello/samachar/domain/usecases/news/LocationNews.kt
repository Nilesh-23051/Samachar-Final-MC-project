package com.hello.samachar.domain.usecases.news

import androidx.paging.PagingData
import com.hello.samachar.domain.model.Article
import com.hello.samachar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(country:String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.locationNews(
            country=country,
            sources = sources
        )
    }
}