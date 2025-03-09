package com.example.challenge.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    val backgroundColor = Color(0xFFABB8A8) // Sage green background
    val cardColor = Color(0xFFD8C3B5) // Light beige for cards

    Scaffold(
        topBar = { ProfileTopBar() },
        bottomBar = { BottomAppBar() },
        containerColor = backgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(backgroundColor)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Profile picture
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE6E6FA)) // Light lavender color
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

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
                        text = "0000",
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

            Spacer(modifier = Modifier.height(24.dp))

            // Medals row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Gold medal
                MedalItem(
                    position = "1",
                    backgroundColor = Color(0xFFFFD700), // Gold
                    count = "0"
                )

                // Silver medal
                MedalItem(
                    position = "2",
                    backgroundColor = Color(0xFFC0C0C0), // Silver
                    count = "0"
                )

                // Bronze medal
                MedalItem(
                    position = "3",
                    backgroundColor = Color(0xFFCD7F32), // Bronze
                    count = "0"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Profile name",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO: Handle navigation */ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Handle edit profile */ }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Profile"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFABB8A8) // Match the background
        )
    )
}

@Composable
fun MedalItem(position: String, backgroundColor: Color, count: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Medal with position number
        Box(
            modifier = Modifier
                .size(60.dp)
        ) {
            // Medal circle
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = position,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            // Ribbon
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 15.dp)
            ) {
                Row(
                    modifier = Modifier.width(40.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 20.dp, height = 30.dp)
                            .background(Color.Red)
                    )
                    Box(
                        modifier = Modifier
                            .size(width = 20.dp, height = 30.dp)
                            .background(Color.Red)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Count
        Text(
            text = count,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BottomAppBar1() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        color = Color(0xFFD8C3B5),
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                modifier = Modifier.size(28.dp)
            )

            // Center profile picture
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF7D8CC4)),
                contentAlignment = Alignment.Center
            ) {
                // Replace with actual profile image
                // Image(painter = painterResource(id = R.drawable.profile), contentDescription = "Profile")
            }

            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Check",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen()
    }
}