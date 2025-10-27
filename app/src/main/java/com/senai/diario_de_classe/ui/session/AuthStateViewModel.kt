package com.senai.diario_de_classe.ui.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senai.diario_de_classe.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

sealed interface AuthState {
    data object Aguardando : AuthState
    data object Unauthenticated : AuthState
    data object Authenticated : AuthState
}

@HiltViewModel
class AuthStateViewModel @Inject constructor(repo: AuthRepository) : ViewModel() {
    val state = repo.tokenFlow()
        .map { token ->
            if(token.isNullOrBlank()) {
                AuthState.Unauthenticated
            } else {
                AuthState.Authenticated
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            AuthState.Aguardando
        )
}