package com.hello.samachar.presentation.details

import com.hello.samachar.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()


    object RemoveSideEffect : DetailsEvent()

}