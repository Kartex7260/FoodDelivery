package kanti.fooddelivery.data.models.foodcategories

import kanti.fooddelivery.data.models.common.RepositoryResult
import kanti.fooddelivery.data.models.common.isNull
import kanti.fooddelivery.data.models.common.isSuccess
import kanti.fooddelivery.data.models.common.toRepositoryResult
import kanti.fooddelivery.data.models.foodcategories.datasource.local.FoodCategoryLocalDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.remote.FoodCategoryRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodCategoryRepositoryImpl @Inject constructor(
	private val foodCategoryLocal: FoodCategoryLocalDataSource,
	private val foodCategoryRemote: FoodCategoryRemoteDataSource
) : FoodCategoryRepository {

	override fun getFoodCategories(): Flow<RepositoryResult<List<FoodCategory>>> {
		return flow {
			val remoteData = foodCategoryRemote.getFoodCategories()
			if (!remoteData.isSuccess) {
				val localData = foodCategoryLocal.getFoodCategories()
				emit(localData.toRepositoryResult())
				return@flow
			}

			emit(remoteData.toRepositoryResult())
			if (!remoteData.isNull) {
				deleteAllAndInsert(remoteData.value!!)
			}
		}
	}

	override suspend fun deleteAllAndInsert(foodCategory: List<FoodCategory>) {
		foodCategoryLocal.deleteAll()
		foodCategoryLocal.insert(foodCategory)
	}
}