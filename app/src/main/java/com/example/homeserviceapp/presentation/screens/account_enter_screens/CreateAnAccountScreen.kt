package com.example.homeserviceapp.presentation.screens.account_enter_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.econifyapp.presentation.theme.dp12
import com.example.econifyapp.presentation.theme.dp18
import com.example.econifyapp.presentation.theme.dp2
import com.example.econifyapp.presentation.theme.dp5
import com.example.econifyapp.presentation.theme.dp50
import com.example.econifyapp.presentation.theme.sp12
import com.example.econifyapp.presentation.theme.sp14
import com.example.econifyapp.presentation.theme.sp28
import com.example.homeserviceapp.R
import com.example.homeserviceapp.presentation.components.OutLinedTextFilled
import com.example.homeserviceapp.presentation.components.PasswordOutLinedTextField
import com.example.homeserviceapp.presentation.navigation.Screens
import com.example.homeserviceapp.presentation.theme.WhiteBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAnAccountScreen(
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.weight(0.5f))
        Image(
            painter = painterResource(id = R.drawable.welcome_clean_img),
            contentDescription = null,
            modifier = modifier.padding(top = dp18)
        )
        Text(
            text = stringResource(R.string.create_new_account),
            fontSize = sp28,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(top = dp12)
        )
        Text(
            text = stringResource(R.string.set_up_your_username_and_password_you_can_always_change_it_later),
            fontSize = sp12,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(top = dp2)
        )
        OutLinedTextFilled(
            typeOfField = "text",
            text = stringResource(R.string.enter_name),
        )
        OutLinedTextFilled(
            typeOfField = "email",
            text = stringResource(R.string.email_address)
        )
        OutLinedTextFilled(
            typeOfField = "number",
            text = stringResource(R.string.mobile_number)
        )
        PasswordOutLinedTextField(
            text = stringResource(R.string.password)
        )
        PasswordOutLinedTextField(
            text = stringResource(R.string.re_enter_password)
        )
        Spacer(modifier = modifier.weight(1f))
        Button(
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            onClick = {
                navController.navigate(Screens.EditProfileScreen.route.toString())
            },
            modifier = modifier
                .fillMaxWidth(0.8f)
                .height(dp50)
                .background(
                    color = WhiteBlue,
                    shape = RoundedCornerShape(dp5)
                ),
        ) {
            Text(
                text = stringResource(R.string.sign_up),
            )
        }
        Spacer(modifier = modifier.weight(0.1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.already_have_an_account),
                textAlign = TextAlign.Center,
                fontSize = sp14
            )
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(
                    text = stringResource(R.string.login),
                    color = WhiteBlue,
                    textAlign = TextAlign.Start
                )
            }
        }
        Spacer(modifier = modifier.weight(1f))
    }
}

@Preview
@Composable
fun CreateAnAccountScreenPreview() {
    CreateAnAccountScreen(
        navController = rememberNavController()
    )
}