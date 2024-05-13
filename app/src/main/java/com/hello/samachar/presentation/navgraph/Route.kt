//For routing the path

package com.hello.samachar.presentation.navgraph

sealed class Route(
    //For each screen we are going to have a route
    val route:String
) {
    //Creating object for different screens
    object OnBoardingScreen:Route(route="onBoardingScreen")
    object HomeScreen:Route(route="homeScreen")
    object SearchScreen:Route(route="searchScreen")
    object BookmarkScreen:Route(route="bookmarkScreen")
    object DetailsScreen:Route(route="detailsScreen")


    //Route for subnavigation
    object AppStartNavigation:Route(route="appStartNavigation")
    object NewsNavigation:Route(route="newsNavigation")
    object NewsNavigatorScreen:Route(route="newsNavigator")
}