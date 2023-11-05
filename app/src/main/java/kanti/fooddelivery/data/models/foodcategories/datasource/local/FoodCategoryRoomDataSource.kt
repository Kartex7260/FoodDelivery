package kanti.fooddelivery.data.models.foodcategories.datasource.local

import kanti.fooddelivery.data.models.common.LocalResult
import kanti.fooddelivery.data.models.foodcategories.FoodCategory
import javax.inject.Inject

class FoodCategoryRoomDataSource @Inject constructor(
	private val foodCategoryDao: FoodCategoryDao
) : FoodCategoryLocalDataSource {

	override suspend fun getFoodCategories(): LocalResult<List<FoodCategory>> {
		return LocalResult(
			value = foodCategoryDao.getFoodCategories().map { it.asFoodCategory }
		)
	}

	override suspend fun insert(foodCategory: List<FoodCategory>) {
		foodCategoryDao.insert(foodCategory.map { it.asFoodCategoryEntity })
	}

	override suspend fun delete(foodCategory: List<FoodCategory>) {
		foodCategoryDao.delete(foodCategory.map { it.asFoodCategoryEntity })
	}

	override suspend fun deleteAll() {
		foodCategoryDao.deleteAll()
	}
}