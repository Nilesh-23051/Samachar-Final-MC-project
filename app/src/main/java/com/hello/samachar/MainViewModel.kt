//From where we have to start

package com.hello.samachar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hello.samachar.domain.usecases.app_entry.AppEntryUseCases
import com.hello.samachar.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn

import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //Inject Use cases
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel(){
    //We will get the value of the AppEntry Key from the data store prefernces and check if that's true then
    //we can just go to the NewsNavigator Screen and if false then we can show the OnBoardingScreen

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set  //This means that the startDestination variable can only be modified within the class where it's declared. Other classes cannot modify its value directly.

    init{
        appEntryUseCases.readAppEntry().onEach{shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                startDestination = Route.NewsNavigation.route
            }else{
                startDestination = Route.AppStartNavigation.route
            }
            delay(300)
            splashCondition = false


        }.launchIn(viewModelScope)
    }
}