package kanti.fooddelivery.data.models.foodcategories.datasource.remote

import com.google.gson.annotations.SerializedName
import kanti.fooddelivery.data.models.foodcategories.FoodCategory

data class FoodCategoryMetaData(
	val ok: Boolean,
	@SerializedName("mensaje") val message: String,
	val data: List<FoodCategoryDTO>?
) {

	val asFoodCategories: List<FoodCategory>? get() = data?.map { it.asFoodCategory }

}

data class FoodCategoryDTO(
	val id: Int,
	@SerializedName("nombre") val name: String
)

val FoodCategoryDTO.asFoodCategory: FoodCategory get() {
	return FoodCategory(id, name)
}