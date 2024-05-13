//This class will have the events that will be sent from the UI to the ViewModel

package com.hello.samachar.presentation.onboarding

sealed class OnBoardingEvent {
    object SaveAppEntry: OnBoardingEvent()
}