package com.example.homeserviceapp.presentation.screens.on_boarding_screens.on_boarding_screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.homeserviceapp.presentation.components.OnBoardingScreenComponent
import com.example.homeserviceapp.presentation.navigation.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreens(
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {
        2
    })
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        OnBoardingScreenComponent(
            index = page,
            onNextButtonClick = {
                if (page==1){
                    navController.navigate(Screens.CreateAnAccountScreen.route.toString())
                }else{
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                }
            },
            onSkipButtonClick = {
                navController.navigate(Screens.CreateAnAccountScreen.route.toString())
            }
        )
    }
}