package kanti.fooddelivery.data.models.food.datasources.remote

import com.google.gson.annotations.SerializedName
import kanti.fooddelivery.data.models.food.Food

data class FoodMetaData(
	val ok: Boolean,
	@SerializedName("mensaje") val message: String,
	@SerializedName("productos") val foods: List<FoodDTO>?
) {

	val asFoods: List<Food>? get() = foods?.map { it.asFood }

}

data class FoodDTO(
	val id: Int,
	@SerializedName("nombre") val title: String,
	@SerializedName("descripcion") val composition: String,
	@SerializedName("precio") val minPrice: Int,
	@SerializedName("linkImagen") val imageUrl: String,
	@SerializedName("vendible") val foodType: Int
)

val FoodDTO.asFood: Food get() {
	return Food(
		id = id,
		title = title,
		composition = composition,
		minPrice = minPrice,
		imageUrl = imageUrl,
		foodType = foodType
	)
}
