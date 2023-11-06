package kanti.fooddelivery.data.models.food

import kanti.fooddelivery.data.models.common.RepositoryResult
import kanti.fooddelivery.data.models.common.isNull
import kanti.fooddelivery.data.models.common.isSuccess
import kanti.fooddelivery.data.models.common.toRepositoryResult
import kanti.fooddelivery.data.models.food.datasources.local.FoodLocalDataSource
import kanti.fooddelivery.data.models.food.datasources.remote.FoodRemoteDataSource
import kanti.fooddelivery.data.services.log.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class FoodRepositoryImpl @Inject constructor(
	private val foodLocal: FoodLocalDataSource,
	private val foodRemote: FoodRemoteDataSource,
	private val logger: Logger
) : FoodRepository {

	private val logTag = "FoodRepositoryImpl"

	override fun getFoods(): Flow<RepositoryResult<List<Food>>> {
		return flow {
			val remoteData = foodRemote.getFoods()
			logger.d(logTag, "FoodRemote return data=$remoteData")
			if (!remoteData.isSuccess) {
				val localData = foodLocal.getFoods()
				emit(localData.toRepositoryResult())
				return@flow
			}

			emit(remoteData.toRepositoryResult())
			if (!remoteData.isNull) {
				deleteAllAndInsert(remoteData.value!!)
			}
		}
	}

	override suspend fun deleteAllAndInsert(food: List<Food>) {
		foodLocal.deleteAll()
		foodLocal.insert(food)
	}
}