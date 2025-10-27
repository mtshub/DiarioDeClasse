package com.senai.diario_de_classe.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senai.diario_de_classe.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState> = _uiState

    fun onEmailChange(v: String) = _uiState.update { it.copy(email = v) }
    fun onSenhaChange(v: String) = _uiState.update { it.copy(senha = v) }

    fun login(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _uiState.update { it.copy(aguardando = true, error = null) }
            try {
                val ok = repo.login(_uiState.value.email, _uiState.value.senha)
                if (ok) onSuccess()
                else _uiState.update { it.copy(aguardando = false, error = "Falha no login") }
            } catch (e: Exception) {
                _uiState.update { it.copy(aguardando = false, error = e.message ?: "Erro no login") }
            }
        }
    }

}