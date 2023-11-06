package kanti.fooddelivery.ui.view.recycleradapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kanti.fooddelivery.R
import kanti.fooddelivery.data.models.food.Food

typealias ImageLoadFun = (image: ImageView, imageUrl: String) -> Unit

class FoodItemRecyclerAdapter(
	items: List<Food> = listOf(),
	private val loadImage: ImageLoadFun
) : RecyclerView.Adapter<FoodItemRecyclerAdapter.FoodItemViewHolder>() {

	class FoodItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		val imageView: ImageView = itemView.findViewById(R.id.viewFoodCardImage)
		val foodTitle: TextView = itemView.findViewById(R.id.viewFoodCardTitle)
		val foodComposition: TextView = itemView.findViewById(R.id.viewFoodCardComposition)
		val minPriceButton: Button = itemView.findViewById(R.id.viewFoodCardMinPrice)

	}

	var items: List<Food> = items
		@SuppressLint("NotifyDataSetChanged")
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
		return FoodItemViewHolder(
			LayoutInflater.from(parent.context)
				.inflate(R.layout.view_food_card, parent, false)
		)
	}

	override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
		val food = items[position]

		holder.apply {
			foodTitle.text = food.title
			foodComposition.text = food.composition
			
			val fromPrefix = holder.itemView.context
				.getString(R.string.view_food_card_price_from)
			val currencyPostfix = holder.itemView.context
				.getString(R.string.view_food_card_price_currency)
			
			minPriceButton.text = buildString {
				append(fromPrefix)
				append(" ")
				append(food.minPrice)
				append(currencyPostfix)
			}

			if (food.imageUrl != null)
				loadImage(imageView, food.imageUrl)
		}
	}

	override fun getItemCount(): Int = items.size
}