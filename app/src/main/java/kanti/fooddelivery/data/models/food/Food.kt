package kanti.fooddelivery.data.models.food

data class Food(
	val title: String,
	val composition: String,
	val minPrice: Int,
	val imageUrl: String,
	val foodType: Int
)
