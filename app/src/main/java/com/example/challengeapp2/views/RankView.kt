package com.example.challengeapp2.views


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RankView() {
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
                .padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Rank 1 picture

            // Gold medal
            MedalItemNoPosition(
                backgroundColor = Color(0xFFFFD700), // Gold
                sizeMulplyer = 2f, cont = "9999"
            )


            // Points card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = cardColor)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Top 1 Tier Player Nick",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Gray.copy(alpha = 0.3f)
            )

            LazyColumnExample()

        }
    }
}

@Composable
fun BottomAppBarChallanger() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        color = cardColor,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(28.dp),
                    tint = Color.White
                )
            }

            // Center profile picture
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                // Replace with actual profile image
                // Image(painter = painterResource(id = R.drawable.profile), contentDescription = "Profile")
                PodiumIcon()
            }

            TaskBox()
        }
    }
}

@Composable
fun TaskBox() {
    Box(
        modifier = Modifier
            .size(50.dp) // Tamanho do Box
            .background(Color.Gray, shape = CircleShape), // Cor azul e formato circular
        contentAlignment = Alignment.Center // Centraliza o ícone dentro do Box
    ) {
        Icon(
            imageVector = Icons.Default.Check, // Ícone de check padrão do Material Icons
            contentDescription = "Task Completed",
            tint = Color.White, // Ícone branco
            modifier = Modifier.size(30.dp) // Ajusta o tamanho do ícone
        )
    }
}

@Composable
fun PodiumIcon() {

    val multiplayer = 6f

    Row(
        modifier = Modifier
            .height(3.dp*multiplayer) // Altura total do pódio
            .wrapContentWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom // Alinhar os retângulos na base
    ) {
        // 2º Lugar - Médio
        Box(
            modifier = Modifier
                .width(1.dp*multiplayer)
                .height(2.dp*multiplayer) // Tamanho médio
                .background(Color.White)
        )

        // 1º Lugar - Maior
        Box(
            modifier = Modifier
                .width(1.dp*multiplayer)
                .height(3.dp*multiplayer) // Tamanho maior
                .background(Color.White)
        )

        // 3º Lugar - Menor
        Box(
            modifier = Modifier
                .width(1.dp*multiplayer)
                .height(1.dp*multiplayer) // Tamanho menor
                .background(Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RankViewPreview() {
    MaterialTheme {
        RankView()
    }

}

@Composable
fun MedalItemNoPosition(backgroundColor: Color, cont: String = "", sizeMulplyer: Float = 1f) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Medal with position number
        Box(
            modifier = Modifier.size(60.dp * sizeMulplyer)
        ) {
            // Medal circle
            Box(
                modifier = Modifier
                    .size(60.dp * sizeMulplyer)
                    .clip(CircleShape)
                    .background(backgroundColor), contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(0.75f)
                        .clip(CircleShape)
                        .background(Color(0xFFE6E6FA)) // Light lavender color
                    , contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(0.7f),
                        tint = Color.Gray
                    )
                }
            }

            // Ribbon
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 15.dp * sizeMulplyer)
            ) {
                Row(
                    modifier = Modifier.width(40.dp * sizeMulplyer)
                ) {
                    Box(
                        modifier = Modifier
                            .size(
                                width = 40.dp * sizeMulplyer, height = 30.dp * sizeMulplyer
                            )
                            .background(Color.Red), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = cont,
                            fontSize = 15.sp * sizeMulplyer,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                }
            }


        }
        Spacer(modifier = Modifier.height(24.dp * sizeMulplyer))
    }

}

@Composable
fun CardModel(title: String) {
    val cardColor = Color(0xFFD8C3B5)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SilverModel(title: String) {

    val cardColor = Color(0xFFD8C3B5)


    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        // Silver medal
        MedalItemNoPosition(
            backgroundColor = Color(0xFFC0C0C0), // Silver
            cont = "175"
        )
        Spacer(modifier = Modifier.width(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = cardColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun BronzeModel(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        // Bronze medal
        MedalItemNoPosition(
            backgroundColor = Color(0xFFCD7F32), // Bronze
            cont = "120"
        )
        Spacer(modifier = Modifier.width(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = cardColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun LazyColumnExample() {
    // Lista de títulos para os cartões
    val titles = listOf("Título 2", "Título 3", "Título 4", "Título 5")

    // LazyColumn para exibir os cartões
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espaço entre os itens
        contentPadding = PaddingValues(16.dp) // Margem nas bordas
    ) {
        itemsIndexed(titles) { index, title ->
            when {
                index == 0 -> {
                    // Caso quando o índice for 1
                    SilverModel(title = title)
                }

                index == 1 -> {
                    // Caso quando o índice for 2
                    BronzeModel(title = title)
                }

                else -> {
                    CardModel(title = title) // Chama o CardModel para cada item da lista
                }

            }
        }
    }
}