package kanti.fooddelivery.ui.view.recycleradapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import kanti.fooddelivery.R
import kanti.fooddelivery.data.models.discounts.Discount

class DiscountRecyclerAdapter(
	items: List<Discount>,
	private val loadImage: (ImageView, String) -> Unit
) : RecyclerView.Adapter<DiscountRecyclerAdapter.DiscountViewHolder>() {

	var items: List<Discount> = items
		set(value) {
			field = value
		}

	class DiscountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		val imageView: ShapeableImageView = itemView as ShapeableImageView

	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
		return DiscountViewHolder(
			LayoutInflater.from(parent.context)
				.inflate(R.layout.view_food_list_discount, parent, false) as ShapeableImageView
		)
	}

	override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {
		val discount = items[position]
		loadImage(holder.imageView, discount.imageUrl)
	}

	override fun getItemCount(): Int = items.size
}