package kanti.fooddelivery.data.models.foodcategories

import kanti.fooddelivery.data.models.common.RepositoryResult
import kotlinx.coroutines.flow.Flow

interface FoodCategoryRepository {

	fun getFoodCategories(): Flow<RepositoryResult<List<FoodCategory>>>

	suspend fun deleteAllAndInsert(foodCategory: List<FoodCategory>)

}