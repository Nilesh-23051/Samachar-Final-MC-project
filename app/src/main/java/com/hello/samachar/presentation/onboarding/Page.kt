//Contains each page information

package com.hello.samachar.presentation.onboarding

import androidx.annotation.DrawableRes
import com.hello.samachar.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image:Int,

)

//List of pages
val pages=listOf(
    Page(
        title = "Welcome to Our Samachar App!",
        description = "Stay updated with the latest news from around the world.",
        image = R.drawable.onboarding1,
    ),
    Page(
        title = "Customize Your News Feed",
        description = "Choose your favorite topics and personalize your news feed.",
        image = R.drawable.onboarding2,
    ),
    Page(
        title = "Discover Trending Stories",
        description = "Explore trending news articles and stay informed.",
        image = R.drawable.onboarding3,
    ),
)