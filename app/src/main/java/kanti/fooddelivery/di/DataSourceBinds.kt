package kanti.fooddelivery.di

import dagger.Binds
import kanti.fooddelivery.data.models.food.datasources.remote.FoodRemoteDataSource
import kanti.fooddelivery.data.models.food.datasources.remote.FoodRetrofitDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.remote.FoodCategoryRemoteDataSource
import kanti.fooddelivery.data.models.foodcategories.datasource.remote.FoodCategoryRetrofitDataSource

interface DataSourceBinds {

	@Binds
	fun bindFoodRetrofitDataSource(dataSource: FoodRetrofitDataSource): FoodRemoteDataSource

	@Binds
	fun bindFoodCategoriesRetrofitDataSource(
		dataSource: FoodCategoryRetrofitDataSource
	): FoodCategoryRemoteDataSource

}