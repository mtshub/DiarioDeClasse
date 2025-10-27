package com.senai.diario_de_classe.ui.cadastro

import android.net.Uri
import com.senai.diario_de_classe.domain.model.Usuario

data class CadastroUIState(
    val labelNome: String = "",
    val labelEmail: String = "",
    val labelSenha: String = "",
    val labelConfirmarSenha: String = "",
    val usuarios: List<Usuario> = emptyList(),
    val fotoUri: Uri? = null,
    val senhaNaoCoincide: Boolean = false,
    val cadastroSucesso: Boolean = false
)
