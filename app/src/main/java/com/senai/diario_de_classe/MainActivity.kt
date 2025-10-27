package com.senai.diario_de_classe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.senai.diario_de_classe.ui.DiarioDeClasseTheme
import com.senai.diario_de_classe.ui.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            DiarioDeClasseTheme (darkTheme = false) {
//                Scaffold(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .fillMaxWidth()
//                ) { innerPadding ->
//                    DiarioDeClasseApp(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                            .fillMaxWidth()
//                    )
//                }
//            }
            DiarioDeClasseTheme {
                val nav = rememberNavController()
                AppNavGraph(nav)
            }
        }
    }
}

//@Composable
//fun CardAluno(
//    modifier: Modifier = Modifier,
////    nomeAluno: String = stringResource(R.string.nome_padrao),
////    turmaAluno: String = stringResource(R.string.turma_padrao),
////    foto: Int = R.drawable.foto_perfil
//    aluno: Aluno = Aluno("Matheus", curso = "Desenvolvimento de Sistemas")
//) {
//    Card(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 15.dp, end = 15.dp)
//            .clip(RoundedCornerShape(bottomStart = 25.dp, topEnd = 25.dp, topStart = 0.dp, bottomEnd = 0.dp)),
//    ) {
//        Row(
//            modifier
//                .fillMaxWidth()
//                .padding(start = 15.dp, end = 15.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            FotoPerfilAluno(Modifier.size(100.dp), idImagem = aluno.foto)
//            InformacoesDoAluno(fontSizeNome = 20.sp, aluno = aluno)
//        }
//    }
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DiarioDeClasseApp(modifier: Modifier = Modifier) {
//    val layoutDirection = LocalLayoutDirection.current
//    Surface(
//        modifier
//            .fillMaxSize()
//            .statusBarsPadding()
//            .padding(
//                start = WindowInsets.safeDrawing.asPaddingValues()
//                    .calculateStartPadding(layoutDirection),
//                end = WindowInsets.safeDrawing.asPaddingValues()
//                    .calculateEndPadding(layoutDirection),
//            ),
//    ) {
//        ListaDeAlunos(modifier, DataSource().carregarAlunos())
//    }
//}
//
//
//@Composable
//fun FotoPerfilAluno(modifier: Modifier = Modifier, idImagem: Int) {
//    Image(
//        painter = painterResource(idImagem),
//        contentDescription = "",
//        modifier.clip(CircleShape)
//    )
//}
//
//@Composable
//fun InformacoesDoAluno(
//    modifier: Modifier = Modifier,
////    nomeAluno: String,
////    turmaAluno: String,
//    aluno: Aluno,
//    fontSizeNome: TextUnit = 15.sp,
//    fontSizeTurma: TextUnit = 15.sp,
//    fontSizeGeral: TextUnit? = null
//) {
//    val fontSizeN = fontSizeGeral ?: fontSizeNome
//    val fontSizeT = fontSizeGeral ?: fontSizeTurma
//    Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
//        Text(aluno.nome, fontSize = fontSizeN)
//        Text(aluno.curso, fontSize = fontSizeT)
//    }
//}
//
//@Composable
//fun ListaDeAlunos(modifier: Modifier = Modifier, listaDeAlunos: List<Aluno>) {
//    LazyColumn {
//        items(listaDeAlunos) { aluno ->
//            CardAluno(modifier, aluno)
//        }
//    }
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun DiarioDeClassePreview() {
//    DiarioDeClasseTheme(darkTheme = true) {
//        Scaffold(
//            modifier = Modifier
//                .fillMaxSize()
//                .fillMaxWidth()
//        ) { innerPadding ->
//            DiarioDeClasseApp(
//                modifier = Modifier
//                    .padding(innerPadding)
//                    .fillMaxWidth()
//            )
//        }
//    }
//}