package kanti.fooddelivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.fooddelivery.data.models.food.FoodRepository
import kanti.fooddelivery.data.models.food.FoodRepositoryImpl
import kanti.fooddelivery.data.models.food.datasources.local.FoodLocalDataSource
import kanti.fooddelivery.data.models.food.datasources.local.FoodRoomDataSource
import kanti.fooddelivery.data.models.food.datasources.remote.FoodRemoteDataSource
import kanti.fooddelivery.data.models.food.datasources.remote.FoodRetrofitDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface FoodBinds {

	@Binds
	fun bindFoodRetrofitDataSource(dataSource: FoodRetrofitDataSource): FoodRemoteDataSource

	@Binds
	fun bindFoodRoomDataSource(dataSource: FoodRoomDataSource): FoodLocalDataSource

	@Binds
	@Singleton
	fun bindFoodRepositoryImpl(repository: FoodRepositoryImpl): FoodRepository

}