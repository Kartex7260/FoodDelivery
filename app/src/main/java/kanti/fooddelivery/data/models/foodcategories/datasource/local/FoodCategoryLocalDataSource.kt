package kanti.fooddelivery.data.models.foodcategories.datasource.local

import kanti.fooddelivery.data.models.common.LocalResult
import kanti.fooddelivery.data.models.foodcategories.FoodCategory

interface FoodCategoryLocalDataSource {

	suspend fun getFoodCategories(): LocalResult<List<FoodCategory>>

	suspend fun insert(foodCategory: List<FoodCategory>)

	suspend fun delete(foodCategory: List<FoodCategory>)

	suspend fun deleteAll()

}