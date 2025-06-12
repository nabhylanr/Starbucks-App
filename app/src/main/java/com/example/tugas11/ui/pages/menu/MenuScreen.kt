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
    val (search, setSearch) = rememberSaveable {
        mutableStateOf("")
    }

    val menu = MenuRepository.drinks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 32.dp,
                top = 32.dp,
                end = 32.dp,
                bottom = 50.dp
            )
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
            Spacer(modifier = Modifier.size(20.dp))
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = "Good Morning!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF008883)
                )
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = "Start your order and savor it now.",
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Menu",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF008883)
        )

        Spacer(modifier = Modifier.size(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            RoundedCategory(text = "All", backgroundColor = Color(0xFFAAE0DE))
            RoundedCategory(text = "Coffee", backgroundColor = Color(0xFFDFE4EC))
            RoundedCategory(text = "Non-coffee", backgroundColor = Color(0xFFDFE4EC))
        }

        Spacer(modifier = Modifier.size(20.dp))

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(150.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(menu) { photo ->
                    MenuCard(menu = photo)
                }
                item { Spacer(modifier = Modifier.padding(20.dp)) }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun RoundedCategory(text: String, backgroundColor: Color = Color.LightGray) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
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
