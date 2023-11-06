package kanti.fooddelivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.fooddelivery.data.models.foodcategories.FoodCategoryRepository
import kanti.fooddelivery.data.models.foodcategories.FoodCategoryRepositoryImpl
import kanti.fooddelivery.data.models.foodcategories.datasource.local.FoodCategoryLocalDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.local.FoodCategoryRoomDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.remote.FoodCategoryRemoteDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.remote.FoodCategoryRetrofitDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface FoodCategoryBinds {

	@Binds
	fun bindFoodCategoriesRetrofitDataSource(
		dataSource: FoodCategoryRetrofitDataSource
	): FoodCategoryRemoteDataSource

	@Binds
	fun bindFoodCategoriesRoomDataSource(
		dataSource: FoodCategoryRoomDataSource
	): FoodCategoryLocalDataSource

	@Binds
	@Singleton
	fun bindFoodCategoryRepositoryImpl(
		repository: FoodCategoryRepositoryImpl
	): FoodCategoryRepository

}