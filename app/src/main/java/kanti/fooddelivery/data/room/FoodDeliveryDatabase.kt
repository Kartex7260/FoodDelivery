package kanti.fooddelivery.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import kanti.fooddelivery.data.models.food.datasources.local.FoodDao
import kanti.fooddelivery.data.models.food.datasources.local.FoodEntity
import kanti.fooddelivery.data.models.foodcategories.datasource.local.FoodCategoryDao
import kanti.fooddelivery.data.models.foodcategories.datasource.local.FoodCategoryEntity

@Database(
	version = 1,
	entities = [
		FoodEntity::class,
		FoodCategoryEntity::class
	]
)
abstract class FoodDeliveryDatabase : RoomDatabase() {

	abstract fun foodDao(): FoodDao

	abstract fun foodCategoryDao(): FoodCategoryDao

}