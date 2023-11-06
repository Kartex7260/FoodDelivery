package kanti.fooddelivery.data.models.food

import kanti.fooddelivery.data.models.common.RepositoryResult
import kotlinx.coroutines.flow.Flow

interface FoodRepository {

	fun getFoods(): Flow<RepositoryResult<List<Food>>>

	suspend fun deleteAllAndInsert(food: List<Food>)

}