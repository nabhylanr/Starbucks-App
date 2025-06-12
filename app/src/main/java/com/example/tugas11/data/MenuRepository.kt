package com.example.tugas11.data

import com.example.tugas11.R
import com.example.tugas11.model.Menu

object MenuRepository {
    val drinks = listOf(
        Menu(
            nameRes = R.string.drink_1_name,
            priceRes = R.string.drink_1_price,
            imageRes = R.drawable.drink_1
        ),
        Menu(
            nameRes = R.string.drink_2_name,
            priceRes = R.string.drink_2_price,
            imageRes = R.drawable.drink_2
        ),
        Menu(
            nameRes = R.string.drink_3_name,
            priceRes = R.string.drink_3_price,
            imageRes = R.drawable.drink_3
        ),
        Menu(
            nameRes = R.string.drink_4_name,
            priceRes = R.string.drink_4_price,
            imageRes = R.drawable.drink_4
        ),
        Menu(
            nameRes = R.string.drink_5_name,
            priceRes = R.string.drink_5_price,
            imageRes = R.drawable.drink_5
        ),
        Menu(
            nameRes = R.string.drink_6_name,
            priceRes = R.string.drink_6_price,
            imageRes = R.drawable.drink_6
        )
    )
}