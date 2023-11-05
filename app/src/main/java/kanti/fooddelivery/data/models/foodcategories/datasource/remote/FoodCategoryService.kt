package kanti.fooddelivery.data.models.foodcategories.datasource.remote

import retrofit2.Call
import retrofit2.http.GET

interface FoodCategoryService {

	@GET("tags")
	suspend fun getFoodCategories(): Call<FoodCategoryMetaData>

}