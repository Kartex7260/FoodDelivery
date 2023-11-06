package kanti.fooddelivery.data.models.foodcategories.datasource.remote

import kanti.fooddelivery.data.models.common.RemoteResult
import kanti.fooddelivery.data.models.common.remoteTryCatch
import kanti.fooddelivery.data.models.foodcategories.FoodCategory
import retrofit2.awaitResponse
import java.io.IOException
import javax.inject.Inject

class FoodCategoryRetrofitDataSource @Inject constructor(
	private val foodCategoryService: FoodCategoryService
) : FoodCategoryRemoteDataSource {

	override suspend fun getFoodCategories(): RemoteResult<List<FoodCategory>> {
		return remoteTryCatch {
			try {
				val foodCategoriesResponse = foodCategoryService.getFoodCategories()
				RemoteResult(
					value = foodCategoriesResponse.asFoodCategories
				)
			} catch (ex: IOException) {
				RemoteResult(type = RemoteResult.Type.NoConnection(ex.message))
			}
		}
	}
}