package kanti.fooddelivery.data.models.foodcategories.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kanti.fooddelivery.data.models.foodcategories.FoodCategory

@Entity("food_category")
data class FoodCategoryEntity(
	@PrimaryKey val id: Int = 0,
	val name: String = ""
)

val FoodCategoryEntity.asFoodCategory: FoodCategory get() {
	return FoodCategory(
		id = id,
		name = name
	)
}

val FoodCategory.asFoodCategoryEntity: FoodCategoryEntity get() {
	return FoodCategoryEntity(
		id = id,
		name = name
	)
}
