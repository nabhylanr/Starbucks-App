package com.example.tugas11.ui.pages.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugas11.R
import com.example.tugas11.ui.components.BottomNavigationBar

@Composable
fun ProfileActivity(
    navHostController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navHostController)
        }
    ) { innerPadding ->
        ProfileScreen(
            modifier = Modifier.padding(innerPadding),
            onSignInClick = {
                navHostController.navigate("SignIn") {
                    popUpTo(0)
                }
            }
        )
    }
}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008883)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_pic),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                ProfileField(label = "Name", value = "Ardhika Krishna")
                Spacer(modifier = Modifier.height(8.dp))
                ProfileField(label = "Email", value = "ardhika@gmail.com")
                Spacer(modifier = Modifier.height(8.dp))
                ProfileField(label = "Birth Date", value = "25/03/2004")
                Spacer(modifier = Modifier.height(8.dp))
                ProfileField(label = "Phone", value = "081234567890")
                Spacer(modifier = Modifier.height(8.dp))
                ProfileField(label = "Address", value = "Surabaya, Indonesia")
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSignInClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF01A29D)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Logout", fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun ProfileField(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
        Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}