package com.example.homeserviceapp.presentation.screens.edit_profile_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.econifyapp.presentation.theme.dp1
import com.example.econifyapp.presentation.theme.dp10
import com.example.econifyapp.presentation.theme.dp150
import com.example.econifyapp.presentation.theme.sp24
import com.example.homeserviceapp.R
import com.example.homeserviceapp.presentation.components.TextFields
import com.example.homeserviceapp.presentation.theme.WhiteBlue
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(Color.Black)
        systemUiController.setNavigationBarColor(Color.Black)
    }
    Scaffold(
        containerColor = Color.Black,

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.profile),
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = sp24
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Black),
                navigationIcon = {
                    OutlinedIconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                        border = BorderStroke(dp1, Color.Gray),
                        shape = RoundedCornerShape(dp10)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = modifier
                    .size(dp150)
                    .clip(CircleShape),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = modifier.fillMaxSize(),
                    colors = IconButtonDefaults.filledIconButtonColors(Color.Transparent)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.7f),
                        colors = CardDefaults.cardColors(WhiteBlue)
                    ) {
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            TextFields(
                typeOfField = "text",
                text = "YOUR NAME"
            )
            TextFields(
                typeOfField = "email",
                text = "YOUR EMAIL"
            )
            TextFields(
                typeOfField = "number",
                text = "Mobile Number"
            )
            TextFields(
                typeOfField = "password",
                text = "PASSWORD"
            )
            TextFields(
                typeOfField = "re_password",
                text = "Re-Enter Password"
            )
        }
    }
}

@Preview
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen(
        navController = rememberNavController()
    )
}