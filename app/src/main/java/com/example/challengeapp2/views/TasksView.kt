package com.example.challengeapp2.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TasksView() {
    val backgroundColor = Color(0xFFABB8A8) // Sage green background

    Scaffold(
        bottomBar = { BottomAppBarChallanger() },
        containerColor = backgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(backgroundColor)
                .padding(horizontal = 16.dp)
        ) {
            SearchScreen()
        }

    }
}


@Preview(showBackground = true)
@Composable
fun TasksViewPreview() {
    MaterialTheme {
        TasksView()
    }

}

@Composable
fun SearchScreen() {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Barra de pesquisa + botão
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Digite sua busca...") },
                modifier = Modifier.weight(1f).background(cardColor)
            )

            Button(onClick = { /* Ação de pesquisa */ }) {
                Text("Pesquisar")
            }
        }

        // LazyColumn com um item especial
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) { index ->

                Item(index)
            }
        }
    }
}

// Item comum
@Composable
fun Item(index: Int) {
    val cardColor = Color(0xFFD8C3B5)


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(cardColor, shape = RoundedCornerShape(8.dp)).clip(RoundedCornerShape(8.dp))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB89A86)), // Pequeno espaço antes da descrição
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Item $index",
                fontSize = 16.sp, // Título menor
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 12.dp)
            )


            Text(
                text = "Points: 0000",
                fontSize = 14.sp, // Tamanho menor
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(end = 12.dp)
            )

        }


        Text(
            text = "Descrição do item $index \nDescrição do item $index \nDescrição do item $index \nDescrição do item $index",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            fontSize = 16.sp, // Descrição maior
            textAlign = TextAlign.Justify
        )
    }
}