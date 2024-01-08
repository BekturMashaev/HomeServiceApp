package com.example.homeserviceapp.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.homeserviceapp.presentation.screens.account_enter_screens.CreateAnAccountScreen
import com.example.homeserviceapp.presentation.screens.edit_profile_screens.EditProfileScreen
import com.example.homeserviceapp.presentation.screens.on_boarding_screens.on_boarding_screens.OnBoardingScreens
import com.example.homeserviceapp.presentation.screens.on_boarding_screens.start_screen.StartScreen

@Composable
fun HomeServiceNavigation() {
    val navController = rememberNavController()
    val startScreenRoute = Screens.StartScreen.route.toString()
    val onBoardingScreenRoute = Screens.OnBoardingScreens.route.toString()
    val editProfileScreenRoute = Screens.EditProfileScreen.route.toString()
    val createScreenScreenRoute = Screens.CreateAnAccountScreen.route.toString()
    NavHost(
        navController = navController,
        startDestination = startScreenRoute,
        enterTransition = {
            fadeIn(animationSpec = tween(2000))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(2000))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(2000))
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(2000))
        }
    ) {
        composable(
            startScreenRoute,
        ) {
            StartScreen(
                navController = navController
            )
        }
        composable(onBoardingScreenRoute) {
            OnBoardingScreens(
                navController = navController
            )
        }
        composable(editProfileScreenRoute) {
            EditProfileScreen(
                navController = navController
            )
        }
        composable(createScreenScreenRoute) {
            CreateAnAccountScreen(
                navController = navController
            )
        }

    }
}