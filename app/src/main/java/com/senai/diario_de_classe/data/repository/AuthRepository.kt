package com.senai.diario_de_classe.data.repository

import com.senai.diario_de_classe.data.local.TokenStore
import com.senai.diario_de_classe.data.remote.ApiService
import com.senai.diario_de_classe.data.remote.LoginRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: ApiService,
    private val store: TokenStore
) {
    suspend fun login(email: String, senha: String) : Boolean {
        val token = api.login(LoginRequest(email, senha)).accessToken
        store.saveToken(token)
        return token.isNotBlank()
    }

    suspend fun me() = api.me()

    suspend fun logout() = store.clearToken()

    fun tokenFlow() = store.token
}