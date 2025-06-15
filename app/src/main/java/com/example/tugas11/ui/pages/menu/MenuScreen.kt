package com.example.tugas11.ui.pages.menu

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.tugas11.data.MenuRepository
import com.example.tugas11.ui.components.BottomNavigationBar
import com.example.tugas11.ui.components.MenuCard
import androidx. compose. ui. draw. shadow
import androidx. compose. foundation. lazy. items

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuActivity(
    navHostController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navHostController )
        }
    ) {
        MenuScreen()
    }
}

@Composable
fun MenuScreen() {
    val (search, setSearch) = rememberSaveable { mutableStateOf("") }
    val menu = MenuRepository.drinks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Promo Banner",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 150.dp, width = 0.dp)
                .padding(vertical = 8.dp)
        )

        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_sb),
                contentDescription = "Starbucks Logo",
                modifier = Modifier
                    .size(48.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Starbucks",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                )
                Text(
                    text = "Menu",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF008883),
                    lineHeight = 26.sp
                )
            }
        }

        Spacer(modifier = Modifier.size(8.dp))

        androidx.compose.foundation.lazy.LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(listOf("All", "Coffee", "Non-coffee", "Tea", "Specials")) {
                RoundedCategory(text = it)
            }
        }

        Spacer(modifier = Modifier.size(12.dp))

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(150.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize(),
            content = {
                items(menu) { item ->
                    MenuCard(menu = item)
                }
            }
        )
    }
}

@Composable
fun RoundedCategory(text: String, backgroundColor: Color = Color(0xFF01A29D)) {
    Box(
        modifier = Modifier
            .background(backgroundColor, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MenuScreenPreview() {
    Tugas11Theme {
        MenuScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun MenuActivityPreview() {
    val navController = rememberNavController()
    Tugas11Theme {
        MenuActivity(navController)
    }
}
