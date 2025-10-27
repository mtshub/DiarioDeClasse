package com.senai.diario_de_classe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.senai.diario_de_classe.ui.session.AuthStateViewModel
import androidx.navigation.compose.NavHost
import com.senai.diario_de_classe.ui.session.AuthState
import androidx.navigation.compose.composable
import com.senai.diario_de_classe.ui.cadastro.CadastroScreen
import com.senai.diario_de_classe.ui.login.LoginScreen

@Composable
fun AppNavGraph(nav: NavHostController) {
    val viewmodel: AuthStateViewModel = hiltViewModel()
    val authState = viewmodel.state.collectAsState().value

    NavHost(nav, startDestination = when(authState) {
        AuthState.Authenticated -> "cadastro"
        else -> "login"
    }) {
        composable("login") {
            LoginScreen(onLoginSuccess = {
                nav.navigate("cadastro") {
                    popUpTo("login") { inclusive = true }
                }
            })
        }
        composable("cadastro") {
            CadastroScreen()
        }
    }
}