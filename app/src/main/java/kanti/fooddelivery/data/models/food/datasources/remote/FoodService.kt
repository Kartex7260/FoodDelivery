package kanti.fooddelivery.data.models.food.datasources.remote

import retrofit2.Call
import retrofit2.http.GET

interface FoodService {

	@GET("productos")
	suspend fun getFoods(): Call<FoodMetaData>

}