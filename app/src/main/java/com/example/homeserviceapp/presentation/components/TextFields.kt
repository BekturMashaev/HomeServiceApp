package com.example.homeserviceapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.econifyapp.presentation.theme.dp100
import com.example.econifyapp.presentation.theme.dp15
import com.example.homeserviceapp.R
import com.example.homeserviceapp.presentation.theme.FullWhite
import com.example.homeserviceapp.presentation.theme.WhiteBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFields(
    modifier: Modifier = Modifier,
    typeOfField: String,
    text: String
) {
    val focusManager = LocalFocusManager.current
    val textValue = remember {
        mutableStateOf("")
    }
    val visibility = remember {
        mutableStateOf(false)
    }
    TextField(modifier = modifier
        .fillMaxWidth(0.8f)
        .height(dp100)
        .padding(top = dp15),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = FullWhite,
            containerColor = Color.Transparent,
        ),
        textStyle = when (typeOfField) {
            "text" -> LocalTextStyle.current.copy(
                fontWeight = FontWeight.Bold
            )

            else -> {
                LocalTextStyle.current.copy(
                    fontWeight = FontWeight.Normal
                )
            }
        },
        label = {
            Text(
                fontWeight = when (typeOfField) {
                    "number" -> FontWeight.Normal
                    "re_password" -> FontWeight.Normal
                    else -> FontWeight.Bold
                },
                text = text,
                color = when (typeOfField) {
                    "number" -> WhiteBlue
                    "re_password" -> WhiteBlue
                    else -> FullWhite
                },
            )
        },
        trailingIcon = {
            if (
                typeOfField != "text"
            ) {
                IconButton(onClick = {
                    visibility.value = !visibility.value
                }) {
                    if (visibility.value) {
                        Icon(
                            painter = painterResource(id = R.drawable.visible),
                            contentDescription = null
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.invisible),
                            contentDescription = null
                        )
                    }
                }
            }

        },
        visualTransformation = if (visibility.value) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = when (typeOfField) {
                "email" -> KeyboardType.Email
                "number" -> KeyboardType.Phone
                else -> KeyboardType.Text
            },
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        singleLine = true,
        shape = RoundedCornerShape(dp15)
    )
}