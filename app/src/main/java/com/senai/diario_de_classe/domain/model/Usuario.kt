package com.senai.diario_de_classe.domain.model

import android.net.Uri
import androidx.annotation.DrawableRes
import com.senai.diario_de_classe.R

data class Usuario(
    val nome: String,
    val email: String,
    val senha: String,
    val fotoUri: Uri? = null,
    @DrawableRes val fotoPadrao : Int = R.drawable.foto_perfil
)
