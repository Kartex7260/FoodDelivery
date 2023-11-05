package kanti.fooddelivery.data.models.food.datasources.local

import kanti.fooddelivery.data.models.common.LocalResult
import kanti.fooddelivery.data.models.food.Food

interface FoodLocalDataSource {

	suspend fun getFoods(): LocalResult<List<Food>>

	suspend fun insert(food: List<Food>)

	suspend fun delete(food: List<Food>)

	suspend fun deleteAll()

}