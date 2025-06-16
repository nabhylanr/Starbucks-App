package com.example.tugas11.ui.pages.claimReward

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.Tugas11Theme
import com.example.tugas11.R
import com.example.tugas11.data.RewardRepository
import com.example.tugas11.ui.components.BottomNavigationBar
import com.example.tugas11.ui.components.RewardCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RewardActivity(
    navHostController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navHostController )
        }
    ) {
        RewardScreen()
    }
}

@Composable
fun RewardScreen() {
    val rewards = RewardRepository.rewards

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.logo_sb),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(80.dp),
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = "Reward Options",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    color = Color(0xFF008883)
                )
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "Claim your reward now!",
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn {
            items(rewards) { reward ->
                RewardCard(
                    reward = reward,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RewardScreenPreview() {
    Tugas11Theme {
        RewardScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RewardActivityPreview() {
    val navController = rememberNavController()
    Tugas11Theme {
        RewardActivity(navHostController = navController)
    }
}