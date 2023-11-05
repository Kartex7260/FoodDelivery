package kanti.fooddelivery.data.models.foodcategories.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodCategoryDao {

	@Query("SELECT * FROM food_category")
	suspend fun getFoodCategories(): List<FoodCategoryEntity>

	@Insert
	suspend fun insert(foodCategory: List<FoodCategoryEntity>): LongArray

	@Delete
	suspend fun delete(foodCategory: List<FoodCategoryEntity>)

	@Query("DELETE FROM food_category")
	suspend fun deleteAll()

}