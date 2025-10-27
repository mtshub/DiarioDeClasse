package com.senai.diario_de_classe.ui.cadastro

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.senai.diario_de_classe.domain.model.Usuario
import com.senai.diario_de_classe.domain.model.UsuarioDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CadastroViewModel(application: Application) {
    private val dataSource = UsuarioDataSource(application)
    private val _uiState = MutableStateFlow(CadastroUIState())
    val uiState: StateFlow<CadastroUIState> = _uiState.asStateFlow()

    fun carregarUsuarios() {
        viewModelScope.launch {
            val usuarios = dataSource.carregarUsuarios()

            _uiState.update {
                it.copy(
                    usuarios = usuarios
                )
            }
        }
    }

    fun mudarTextoNome(textoNome: String) {
        _uiState.update { currentState ->
            currentState.copy(labelNome = textoNome)
        }
        reset()
    }

    fun mudarTextoEmail(textoEmail: String) {
        _uiState.update { currentState ->
            currentState.copy(labelEmail = textoEmail)
        }
        reset()
    }

    fun mudarTextoSenha(textoSenha: String) {
        _uiState.update { currentState ->
            currentState.copy(labelSenha = textoSenha)
        }
        reset()
    }

    fun mudarTextoConfirmarSenha(textoSenhaConfirmada: String) {
        _uiState.update { currentState ->
            currentState.copy(labelConfirmarSenha = textoSenhaConfirmada)
        }
        reset()
    }

    fun mudarFoto() {

    }

    fun cadastrar() {
        val state = _uiState.value
        if(state.labelConfirmarSenha.isBlank() || state.labelSenha.isBlank() || (state.labelConfirmarSenha != state.labelSenha)) {
            _uiState.update { it.copy(senhaNaoCoincide = true) }
            return
        }

        if (state.labelNome.isNotBlank() && state.labelEmail.isNotBlank()) {
            val novoUsuario = Usuario(
                nome = state.labelNome,
                email = state.labelEmail,
                senha = state.labelSenha,
                fotoUri = state.fotoUri
            )
            _uiState.update {
                it.copy(
                    usuarios = it.usuarios + novoUsuario,
                    labelNome = "",
                    labelSenha = "",
                    labelEmail = "",
                    labelConfirmarSenha = ""
                )
            }
        }
    }

    fun reset() {
        _uiState.update { currentState ->
            currentState.copy(
                senhaNaoCoincide = false,
                cadastroSucesso = false
            )
        }
    }

}