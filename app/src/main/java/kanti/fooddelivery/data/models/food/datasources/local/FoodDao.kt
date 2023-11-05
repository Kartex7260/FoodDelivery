package kanti.fooddelivery.data.models.food.datasources.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FoodDao {

	@Query("SELECT * FROM food")
	suspend fun getFoods(): List<FoodEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(food: List<FoodEntity>): LongArray

	@Delete
	suspend fun delete(food: List<FoodEntity>)

	@Query("DELETE FROM food")
	suspend fun deleteAll()

}