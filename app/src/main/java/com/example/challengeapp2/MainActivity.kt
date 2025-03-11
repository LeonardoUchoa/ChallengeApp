package com.example.challengeapp2


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.scale
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun QuoteApp() {
    val backgroundColor = Color(0xFFABB8A8) // Sage green background
    val cardColor = Color(0xFFD8C3B5) // Light beige for cards

    Scaffold(
        bottomBar = { BottomAppBar() },
        containerColor = backgroundColor
    ) { paddingValues ->
        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(backgroundColor)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Challenge App",
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            HorizontalDivider(
                modifier = Modifier.padding(bottom = 16.dp),
                thickness = 1.dp,
                color = Color.Black.copy(alpha = 0.3f)
            )

            QuoteList(cardColor = cardColor)
        }
    }
}

@Composable
fun QuoteList(cardColor: Color) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val challenge = listOf("Challenge 1", "Challenge 2", "Challenge 3")

        items(challenge) { Challenge ->
            ChallengeCard(cardColor = cardColor)
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ChallengeCard(cardColor: Color) {
    var isSwitchOn by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "\"Challenge Name\"",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Switch(
                    checked = isSwitchOn,
                    onCheckedChange = {isSwitchOn = it},
                    modifier =  Modifier.scale(0.7f),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color(0xFF005C4B), // Color when switched on
                        checkedTrackColor = Color(0xFFAFDFD6), // Track color when on
                        uncheckedThumbColor = Color.Gray,      // Color when switched off
                        uncheckedTrackColor = Color.LightGray  // Track color when off
                    )
                )

            }

            Text(
                text = "Description",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 2.dp, bottom = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                AvatarGroup()
            }
        }
    }
}

@Composable
fun AvatarGroup() {
    Row {
        // First avatar
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(Color.Yellow)
        ) {
            // Replace with actual image resource
            // Image(painter = painterResource(id = R.drawable.avatar1), contentDescription = null)
        }

        // Second avatar (overlapping)
        Box(
            modifier = Modifier
                .size(28.dp)
                .offset((-8).dp, 0.dp)
                .clip(CircleShape)
                .background(Color(0xFF5A8AD6))
        ) {
            // Replace with actual image resource
            // Image(painter = painterResource(id = R.drawable.avatar2), contentDescription = null)
        }

        // Third avatar (overlapping)
        Box(
            modifier = Modifier
                .size(28.dp)
                .offset((-16).dp, 0.dp)
                .clip(CircleShape)
                .background(Color.Green)
        ) {
            // Replace with actual image resource
            // Image(painter = painterResource(id = R.drawable.avatar3), contentDescription = null)
        }

        // +1 indicator
        Box(
            modifier = Modifier
                .size(28.dp)
                .offset((-24).dp, 0.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.7f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "+1",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun BottomAppBar() {
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
        }
    }
}

// Color variable for bottom app bar
private val cardColor = Color(0xFFD8C3B5) // Light beige

@Preview(showBackground = true)
@Composable
fun QuoteAppPreview() {
    MaterialTheme {
        QuoteApp()
    }
}