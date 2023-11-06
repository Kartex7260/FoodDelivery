package kanti.fooddelivery.ui.fragments.screens.foodlist.viewmodel

import kanti.fooddelivery.data.models.discounts.Discount

data class DiscountUiState(
	val discount: List<Discount>? = null
)