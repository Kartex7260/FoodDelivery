package kanti.fooddelivery.ui.fragments.screens.foodlist.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kanti.fooddelivery.data.models.discounts.DiscountRepository
import kanti.fooddelivery.data.models.food.FoodRepository
import kanti.fooddelivery.data.models.foodcategories.FoodCategoryRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

@HiltViewModel
class FoodListScreenViewModel @Inject constructor(
	private val foodRepository: FoodRepository,
	private val foodCategoryRepository: FoodCategoryRepository,
	private val discountRepository: DiscountRepository
) : ViewModel() {

	private val logTag = "FoodListScreenViewModel"

	private val foodDataMutex = Mutex()
	private val _foodUiState = MutableStateFlow(FoodListScreenUiState())
	val foodUiState = _foodUiState.asStateFlow()

	private val _discountUiState = MutableStateFlow(DiscountUiState())
	val discountUiState = _discountUiState.asStateFlow()

	fun getData() {
		_foodUiState.value = _foodUiState.value.copy(process = true)
		val foodDataJob = getFoodData()
		val discountDataJob = getDiscountData()
		viewModelScope.launch {
			listOf(
				foodDataJob,
				discountDataJob
			).joinAll()
			_foodUiState.value = _foodUiState.value.copy(process = false)
		}
	}

	private fun getFoodData(): Job {
		return viewModelScope.launch {
			val foodFlow = foodRepository.getFoods()
			val foodCategoryFlow = foodCategoryRepository.getFoodCategories()

			launch {
				foodFlow.collectLatest { repositoryResult ->
					Log.d(logTag, "FoodFlow emit data type = ${repositoryResult.type}")
					foodDataMutex.withLock {
						_foodUiState.value = _foodUiState.value.copy(
							foodData = _foodUiState.value.foodData.copy(
								food = repositoryResult.value ?: listOf()
							),
							type = repositoryResult.type
						)
					}
				}
			}
			launch {
				foodCategoryFlow.collectLatest { repositoryResult ->
					Log.d(logTag, "FoodCategoryFlow emit data type = ${repositoryResult.type}")
					foodDataMutex.withLock {
						_foodUiState.value = _foodUiState.value.copy(
							foodData = _foodUiState.value.foodData.copy(
								foodCategory = repositoryResult.value ?: listOf()
							),
							type = repositoryResult.type
						)
					}
				}
			}
		}
	}

	private fun getDiscountData(): Job {
		return viewModelScope.launch {
			val discountData = discountRepository.getDiscounts()
			_discountUiState.value = _discountUiState.value.copy(
				discount = discountData.value,
				type = discountData.type
			)
		}
	}

}