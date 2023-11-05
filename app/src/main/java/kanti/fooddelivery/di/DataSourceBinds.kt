package kanti.fooddelivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.fooddelivery.data.models.food.datasources.local.FoodLocalDataSource
import kanti.fooddelivery.data.models.food.datasources.local.FoodRoomDataSource
import kanti.fooddelivery.data.models.food.datasources.remote.FoodRemoteDataSource
import kanti.fooddelivery.data.models.food.datasources.remote.FoodRetrofitDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.local.FoodCategoryLocalDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.local.FoodCategoryRoomDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.remote.FoodCategoryRemoteDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.remote.FoodCategoryRetrofitDataSource

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceBinds {

	@Binds
	fun bindFoodRetrofitDataSource(dataSource: FoodRetrofitDataSource): FoodRemoteDataSource

	@Binds
	fun bindFoodRoomDataSource(dataSource: FoodRoomDataSource): FoodLocalDataSource

	@Binds
	fun bindFoodCategoriesRetrofitDataSource(
		dataSource: FoodCategoryRetrofitDataSource
	): FoodCategoryRemoteDataSource

	@Binds
	fun bindFoodCategoriesRoomDataSource(
		dataSource: FoodCategoryRoomDataSource
	): FoodCategoryLocalDataSource

}