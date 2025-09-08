package com.senai.diario_de_classe.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.stringResource
import com.senai.diario_de_classe.R

data class Aluno(
    val nome: String = "Nome do Aluno",
    @DrawableRes val foto: Int = R.drawable.foto_perfil,
    val curso: String = "Curso do Aluno"
)
