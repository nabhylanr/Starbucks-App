package com.example.tugas11.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

object NavbarRepository{
    val items = listOf(
        BottomNavigationItem(
            title = "Menu",
            route = "Menu",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Default.Home
        ),
        BottomNavigationItem(
            title = "Reward",
            route = "Reward",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Default.ShoppingCart
        ),
        BottomNavigationItem(
            title = "Profile",
            route = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Default.Person
        ),
    )
}
