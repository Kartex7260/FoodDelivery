package kanti.fooddelivery.ui.fragments.screens.foodlist.viewmodel

import kanti.fooddelivery.data.models.food.Food
import kanti.fooddelivery.data.models.foodcategories.FoodCategory

data class FoodDataUiState(
	val food: List<Food> = listOf(),
	val foodCategory: List<FoodCategory> = listOf()
)
