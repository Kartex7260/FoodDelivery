package kanti.fooddelivery.ui.fragments.screens.foodlist.viewmodel

import kanti.fooddelivery.data.models.common.RepositoryResult

data class FoodListScreenUiState(
	val foodData: FoodDataUiState = FoodDataUiState(),
	val process: Boolean = false,
	val type: RepositoryResult.Type = RepositoryResult.Type.Success
)