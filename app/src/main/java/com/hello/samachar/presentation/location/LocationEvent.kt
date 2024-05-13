package com.hello.samachar.presentation.location

import com.hello.samachar.presentation.search.SearchEvent

sealed class LocationEvent {

    data class country(val country: String) : LocationEvent()

    object SearchNews : LocationEvent()
}
