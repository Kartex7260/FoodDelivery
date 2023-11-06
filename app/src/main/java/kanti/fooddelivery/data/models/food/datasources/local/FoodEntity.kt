package kanti.fooddelivery.data.models.food.datasources.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kanti.fooddelivery.data.models.food.Food

@Entity(tableName = "food")
data class FoodEntity(
	@PrimaryKey val id: Int = 0,
	val title: String = "",
	val composition: String = "",
	@ColumnInfo("min_price") val minPrice: Int = 0,
	@ColumnInfo("image_url") val imageUrl: String? = null,
	@ColumnInfo("food_type") val foodType: Int = 0
)

val FoodEntity.asFood: Food get() {
	return Food(
		id = id,
		title = title,
		composition = composition,
		minPrice = minPrice,
		imageUrl = imageUrl,
		foodType = foodType
	)
}

val Food.asFoodEntity: FoodEntity get() {
	return FoodEntity(
		id = id,
		title = title,
		composition = composition,
		minPrice = minPrice,
		imageUrl = imageUrl,
		foodType = foodType
	)
}
