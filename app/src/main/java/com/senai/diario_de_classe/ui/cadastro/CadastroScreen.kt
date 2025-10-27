package com.senai.diario_de_classe.ui.cadastro

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import com.senai.diario_de_classe.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CadastroScreen(cadastroViewModel: CadastroViewModel = viewModel()) {
    val cadastroUiState by cadastroViewModel.uiState.collectAsState()

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TrocarFoto(onClick = { cadastroViewModel.mudarFoto() })

        CampoTexto(
            value = cadastroUiState.labelNome,
            onValueChange = { cadastroViewModel.mudarTextoNome(it) },
            label = "Nome"
        )

        CampoTexto(
            value = cadastroUiState.labelEmail,
            onValueChange = { cadastroViewModel.mudarTextoEmail(it) },
            label = "Email"
        )

        CampoTexto(
            value = cadastroUiState.labelSenha,
            onValueChange = { cadastroViewModel.mudarTextoSenha(it) },
            label = "Senha",
            isError = cadastroUiState.senhaNaoCoincide
        )

        CampoTexto(
            value = cadastroUiState.labelConfirmarSenha,
            onValueChange = { cadastroViewModel.mudarTextoConfirmarSenha(it) },
            label = "Confirmar Senha",
            isError = cadastroUiState.senhaNaoCoincide
        )

        Botao(onClick = { cadastroViewModel.cadastrar() }, text = "Cadastrar")

        Spacer(modifier = Modifier.height(25.dp))

        Text("Usuários cadastrados:", style = MaterialTheme.typography.titleMedium)
        cadastroUiState.usuarios.forEach { usuario ->
            Row {
                if (usuario.fotoUri == null) {
                    Image(
                        painterResource(usuario.fotoPadrao),
                        "",
                        modifier = Modifier.size(35.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text("${usuario.nome} - ${usuario.email}")
            }
        }

    }
}

@Composable
fun TrocarFoto(
    @DrawableRes fotoPessoa: Int = R.drawable.foto_perfil,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row {
        Image(
            painter = painterResource(id = fotoPessoa),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Botao(
            text = "Trocar Foto",
            modifier = modifier,
            onClick = onClick
        )
    }
}

@Composable
fun CampoTexto(
    value: String = "",
    onValueChange: (String) -> Unit,
    label: String = "",
    isError: Boolean = false,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        isError = isError,
        singleLine = true,
        modifier = modifier,
    )
}

@Composable
fun Botao(
    onClick: () -> Unit,
    text: String = "",
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = text
        )
    }
}

//@Composable
//fun ListaDeUsuarios(
//    modifier: Modifier = Modifier,
//    listaUsuarios: List<Usuario>
//) {
//
//}

@Composable
@Preview(showSystemUi = true)
fun PreviewCadastro() {
    CadastroScreen()
}