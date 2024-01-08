package com.example.homeserviceapp.data.models

import androidx.compose.runtime.Immutable

@Immutable
data class AccountModel(
    val id: String,
    val name: String,
    val email: String,
    val number: String,
    val password: String,
    val reEnteredPassword: String
) {
    companion object {
        val unknown = AccountModel(
            id = String(),
            name = String(),
            email = String(),
            number = String(),
            password = String(),
            reEnteredPassword = String(),
        )
    }
}