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
    object LocationScreen : Route(route = "locationScreen")


    //Route for subnavigation
    object AppStartNavigation:Route(route="appStartNavigation") // will show the onbording screen
    object NewsNavigation:Route(route="newsNavigation") //will show rest of the screen
    object NewsNavigatorScreen:Route(route="newsNavigator")
}