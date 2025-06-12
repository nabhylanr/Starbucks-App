package com.example.tugas11.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Menu(
    @StringRes val nameRes: Int,
    @StringRes val priceRes: Int,
    @DrawableRes val imageRes: Int
)
