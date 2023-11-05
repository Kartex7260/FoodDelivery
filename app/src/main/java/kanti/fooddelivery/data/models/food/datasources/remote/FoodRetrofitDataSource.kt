package kanti.fooddelivery.data.models.food.datasources.remote

import kanti.fooddelivery.data.models.common.RemoteResult
import kanti.fooddelivery.data.models.common.remoteTryCatch
import kanti.fooddelivery.data.models.food.Food
import retrofit2.awaitResponse
import java.io.IOException
import javax.inject.Inject

class FoodRetrofitDataSource @Inject constructor(
	private val foodService: FoodService
) : FoodRemoteDataSource {

	override suspend fun getFoods(): RemoteResult<List<Food>> {
		return remoteTryCatch {
			try {
				val foodCall = foodService.getFoods()
				val foodResponse = foodCall.awaitResponse()
				RemoteResult(
					value = foodResponse.body()?.asFoods,
					type = if (foodResponse.isSuccessful) {
						RemoteResult.Type.Success
					} else {
						RemoteResult.Type.Fail(foodResponse.message())
					}
				)
			} catch (ex: IOException) {
				RemoteResult(type = RemoteResult.Type.NoConnection(ex.message))
			}
		}
	}
}