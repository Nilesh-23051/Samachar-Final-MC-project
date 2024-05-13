//Response of News API
package com.hello.samachar.data.remote.dto

import com.hello.samachar.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)