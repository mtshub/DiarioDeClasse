package com.senai.diario_de_classe.ui.login

data class LoginUIState(
    val email: String = "",
    val senha: String = "",
    val aguardando: Boolean = false,
    val error: String? = null
)
