package kanti.fooddelivery.data.models.food.datasources.local

import kanti.fooddelivery.data.models.common.LocalResult
import kanti.fooddelivery.data.models.food.Food
import javax.inject.Inject

class FoodRoomDataSource @Inject constructor(
	private val foodDao: FoodDao
) : FoodLocalDataSource {

	override suspend fun getFoods(): LocalResult<List<Food>> {
		return LocalResult(foodDao.getFoods().map { it.asFood })
	}

	override suspend fun insert(food: List<Food>) {
		foodDao.insert(food.map { it.asFoodEntity })
	}

	override suspend fun delete(food: List<Food>) {
		foodDao.delete(food.map { it.asFoodEntity })
	}

	override suspend fun deleteAll() = foodDao.deleteAll()
}