package kanti.fooddelivery.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kanti.fooddelivery.Const
import kanti.fooddelivery.data.models.food.datasources.local.FoodDao
import kanti.fooddelivery.data.models.foodcategories.datasource.local.FoodCategoryDao
import kanti.fooddelivery.data.room.FoodDeliveryDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

	@Provides
	@Singleton
	fun provideRoom(@ApplicationContext context: Context): FoodDeliveryDatabase = Room
		.databaseBuilder(context, FoodDeliveryDatabase::class.java, Const.DATABASE_NAME)
		.build()

	@Provides
	@Singleton
	fun provideFoodDao(database: FoodDeliveryDatabase): FoodDao = database.foodDao()

	@Provides
	@Singleton
	fun provideFoodCategoryDao(database: FoodDeliveryDatabase): FoodCategoryDao =
		database.foodCategoryDao()

}