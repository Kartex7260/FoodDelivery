package kanti.fooddelivery.data.models.foodcategories.datasource.remote

import kanti.fooddelivery.data.models.common.RemoteResult
import kanti.fooddelivery.data.models.foodcategories.FoodCategory

interface FoodCategoryRemoteDataSource {

	suspend fun getFoodCategories(): RemoteResult<List<FoodCategory>>

}