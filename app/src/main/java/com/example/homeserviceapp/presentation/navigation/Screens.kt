package com.example.homeserviceapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import com.example.homeserviceapp.R

@SuppressLint("SupportAnnotationUsage")
sealed class Screens(@StringRes val route:Int) {
    object OnBoardingScreens:Screens(R.string.on_boarding_screen_route)
    object StartScreen:Screens(R.string.start_screen_route)
    object EditProfileScreen:Screens(R.string.edit_profile_screen_route)
    object CreateAnAccountScreen:Screens(R.string.create_an_account_screen_route)
}