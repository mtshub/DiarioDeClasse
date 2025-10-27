package com.senai.diario_de_classe.domain.model

import android.content.Context
import kotlinx.coroutines.delay

class UsuarioDataSource(private val context: Context) {

    suspend fun carregarUsuarios(): List<Usuario> {
        delay(1000)

        return listOf(
            Usuario("Matheus Novaes de Oliveira", "mtsnovaes@gmail.com", "12345"),
            Usuario("Luana Sabrina dos Santos Fava", "w_luuuu@gmail.com", "12345"),
            Usuario("Vitor de Souza Alves", "vsalves@gmail.com", "12345")
        )
    }
}