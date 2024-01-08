package com.example.homeserviceapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.econifyapp.presentation.theme.dp12
import com.example.econifyapp.presentation.theme.dp15
import com.example.homeserviceapp.R
import com.example.homeserviceapp.presentation.theme.WhiteBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLinedTextFilled(
    modifier: Modifier = Modifier,
    typeOfField:String,
    text: String
) {
    val focusManager = LocalFocusManager.current
    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(modifier = modifier
        .fillMaxWidth(0.8f)
        .padding(top = dp12),
        value = textValue.value,
        onValueChange = {
            textValue.value=it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = WhiteBlue,
            unfocusedBorderColor = WhiteBlue,
            cursorColor = WhiteBlue
        ),
        label = {
            Text(
                text = text,
                color = WhiteBlue
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = when(typeOfField){
                "email"-> KeyboardType.Email
                "number"-> KeyboardType.Phone
                else-> KeyboardType.Text
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordOutLinedTextField(
    modifier: Modifier = Modifier,
    text: String
) {
    val focusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .padding(top = dp12),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = WhiteBlue,
            unfocusedBorderColor = WhiteBlue,
            cursorColor = WhiteBlue
        ),
        label = {
            Text(
                text = text,
                color = WhiteBlue
            )
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisible.value=!passwordVisible.value
            }) {
                if (passwordVisible.value) {
                    Icon(painter = painterResource(id = R.drawable.visible), contentDescription =null )
                } else {
                    Icon(painter = painterResource(id = R.drawable.invisible), contentDescription =null )
                }
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
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