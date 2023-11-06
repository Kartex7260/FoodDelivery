package kanti.fooddelivery.ui.fragments.screens.foodlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kanti.fooddelivery.data.models.discounts.DiscountRepository
import kanti.fooddelivery.data.models.food.Food
import kanti.fooddelivery.data.models.food.FoodRepository
import kanti.fooddelivery.data.models.foodcategories.FoodCategoryRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodListScreenViewModel @Inject constructor(
	private val foodRepository: FoodRepository,
	private val foodCategoryRepository: FoodCategoryRepository,
	private val discountRepository: DiscountRepository
) : ViewModel() {

	private val _foodData = MutableStateFlow(FoodListScreenUiState())
	val foodData = _foodData.asStateFlow()

	private val _discountData = MutableStateFlow(DiscountUiState())
	val discountData = _discountData.asStateFlow()

	fun getData() {
		_foodData.value = _foodData.value.copy(process = true)
		val foodDataJob = getFoodData()
		val discountDataJob = getDiscountData()
		viewModelScope.launch {
			listOf(
				foodDataJob,
				discountDataJob
			).joinAll()
			_foodData.value = _foodData.value.copy(process = false)
		}
	}

	private fun getFoodData(): Job {
		return viewModelScope.launch {

		}
	}

	private fun getDiscountData(): Job {
		return viewModelScope.launch {

		}
	}

}