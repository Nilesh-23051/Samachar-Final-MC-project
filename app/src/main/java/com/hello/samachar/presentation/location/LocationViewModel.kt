package com.hello.samachar.presentation.location

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.hello.samachar.domain.usecases.news.NewsUseCases
import com.hello.samachar.presentation.search.SearchEvent
import com.hello.samachar.presentation.search.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {
    private var _state = mutableStateOf(LocationState())
    val state: State<LocationState> = _state


    fun onEvent(event: LocationEvent) {
        when (event) {
            is LocationEvent.country -> {
                _state.value = state.value.copy(country=event.country)
            }

            is LocationEvent.SearchNews -> {
                searchNews()
            }
        }
    }

    private fun searchNews() {
        val articles = newsUseCases.locationNews(
            country = state.value.country,
            sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
        ).cachedIn(viewModelScope)
        _state.value = _state.value.copy(articles = articles)
    }

}