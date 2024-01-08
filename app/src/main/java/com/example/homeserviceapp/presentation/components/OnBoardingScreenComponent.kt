package com.example.homeserviceapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.econifyapp.presentation.theme.dp10
import com.example.econifyapp.presentation.theme.dp15
import com.example.econifyapp.presentation.theme.dp2
import com.example.econifyapp.presentation.theme.dp280
import com.example.econifyapp.presentation.theme.dp30
import com.example.econifyapp.presentation.theme.dp32
import com.example.econifyapp.presentation.theme.dp40
import com.example.econifyapp.presentation.theme.dp5
import com.example.econifyapp.presentation.theme.dp8
import com.example.econifyapp.presentation.theme.sp14
import com.example.econifyapp.presentation.theme.sp28
import com.example.homeserviceapp.R
import com.example.homeserviceapp.presentation.theme.GrayBlue
import com.example.homeserviceapp.presentation.theme.GrayWhite
import com.example.homeserviceapp.presentation.theme.WhiteBlue

@Composable
fun OnBoardingScreenComponent(
    modifier: Modifier = Modifier,
    index: Int,
    onNextButtonClick: () -> Unit,
    onSkipButtonClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = if (index == 0) {
                painterResource(id = R.drawable.plumber_img)
            } else {
                painterResource(id = R.drawable.painter_img)
            },
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Column {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        onSkipButtonClick.invoke()
                    },
                    modifier = Modifier
                        .padding(top = dp10, end = dp10),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GrayBlue
                    ),
                ) {
                    Text(
                        text = stringResource(R.string.skip_txt),
                        color = if (isSystemInDarkTheme()) WhiteBlue else Color.Blue,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(dp280)
                    .clip(RoundedCornerShape(topStart = dp30, topEnd = dp30))
                    .background(if (isSystemInDarkTheme()) Color.Black else GrayWhite),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = dp15)
                ) {
                    Text(
                        text = if (index == 0) {
                            stringResource(R.string.fide_best_quality_service_in_budget)
                        } else {
                            stringResource(R.string.provide_best_quality_service_in_budget)
                        },
                        fontSize = sp28,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    )
                    Text(
                        text = if (index == 0) {
                            stringResource(R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_fringilla_in_sed_risus_sit)
                        } else {
                            stringResource(R.string.lorem_ipsum_txt)
                        },
                        fontSize = sp14,
                        textAlign = TextAlign.Center,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = dp5)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier
                            .height(dp10)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(2) { iteration ->
                            val color =
                                if (index == iteration) WhiteBlue else Color.LightGray
                            Box(
                                modifier = Modifier
                                    .padding(start = dp2, end = dp2, bottom = dp5)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(
                                        if (index != iteration) dp8
                                        else dp32
                                    )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        onClick = {
                            onNextButtonClick.invoke()
                        },
                        modifier = modifier
                            .fillMaxWidth(0.9f)
                            .height(dp40)
                            .background(
                                color = WhiteBlue,
                                shape = RoundedCornerShape(15.dp)
                            ),
                    ) {
                        Text(
                            text = stringResource(R.string.next),
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenComponentPreview() {
    OnBoardingScreenComponent(
        index = 1,
        onNextButtonClick = {

        }
    ) {

    }
}