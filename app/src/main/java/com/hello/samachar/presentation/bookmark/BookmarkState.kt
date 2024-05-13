package com.hello.samachar.presentation.bookmark

import com.hello.samachar.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)