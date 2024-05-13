package com.hello.samachar.presentation.location

import androidx.paging.PagingData
import com.hello.samachar.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class LocationState(
    val country: String = "",
    val articles: Flow<PagingData<Article>>? = null
)