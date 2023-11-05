package kanti.fooddelivery.data.models.food.datasources.remote

import kanti.fooddelivery.data.models.common.RemoteResult
import kanti.fooddelivery.data.models.food.Food

interface FoodRemoteDataSource {

	suspend fun getFoods(): RemoteResult<List<Food>>

}