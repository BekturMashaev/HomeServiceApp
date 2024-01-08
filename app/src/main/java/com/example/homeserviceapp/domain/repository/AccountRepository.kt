package com.example.homeserviceapp.domain.repository

import com.example.homeserviceapp.data.models.AccountModel

interface AccountRepository{
    fun addNewAccount(accountModel: AccountModel)

    fun getAnAccount():AccountModel
}