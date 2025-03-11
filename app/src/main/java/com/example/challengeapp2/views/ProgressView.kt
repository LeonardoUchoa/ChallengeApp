package com.example.challengeapp2.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun ProgressView() {
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
            Tasks()
        }

    }
}

@Composable
fun Tasks() {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(4) { index ->
            PlayerTasks("Player $index", index * 100, index+1)
        }
    }
}

@Composable
fun TasksItens(title: String, points: Int, progress: Float = 0.5f) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(cardColor, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB89A86)), // Pequeno espaço antes da descrição
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 16.sp, // Título menor
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 12.dp)
            )


            Text(
                text = "Points: $points",
                fontSize = 14.sp, // Tamanho menor
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(end = 12.dp)
            )

        }
        Text(
            text = "Descrição do item",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            fontSize = 16.sp, // Descrição maior
            textAlign = TextAlign.Justify
        )

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
                .background(Color(0xFFD8C3B5))
                .padding(horizontal = 12.dp),
            color = Color.Red, //progress color
        )//70% progress

        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Composable

fun PlayerTasks(name: String, points: Int, tasks: Int) {

    ProfileHeader(name, points)
    LazyColumn(modifier = Modifier.heightIn(0.dp, 500.dp)){
        items(tasks) { index ->
            TasksItens("Item $index", index * 100, index.toFloat() / 10f)
        }
    }

}

@Composable
fun ProfileHeader(name: String, points: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Foto de perfil (bolinha com ícone simples)
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFFE6E6FA)) // Light lavender color
                .padding(1.dp)
            , contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = Color.Gray
            )
        }

        // Nome da pessoa no centro
        Text(
            text = name,
            modifier = Modifier.weight(1f).padding( start = 16.dp), // Isso vai empurrar o nome para o centro
            textAlign = TextAlign.Start
        )

        // Pontuação total no formato 0000
        Text(
            text = "$points",
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressViewPreview() {
    MaterialTheme {
        ProgressView()
    }
}