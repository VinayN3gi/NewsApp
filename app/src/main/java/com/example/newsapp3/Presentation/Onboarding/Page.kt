package com.example.newsapp3.Presentation.Onboarding

import androidx.annotation.DrawableRes
import com.example.newsapp3.R

data class Page(
    val title:String="",
    val description:String="",
    @DrawableRes val image:Int=0
)


val OnBoardingPageList= listOf<Page>(
    Page(
        title = "Stay Informed, Stay Ahead",
        description = "Get breaking news, in-depth stories, and real-time updates tailored just for you. Your world, delivered daily.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "News that Fits Your Interests",
        description = "Personalize your feed to follow topics you care about—sports, tech, politics, and more. It’s your news, your way.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Fast, Reliable, and Always Updated",
        description = "Never miss a beat with the latest headlines and trusted reporting, all in one place. News that keeps you connected.",
        image = R.drawable.onboarding3
    )
)