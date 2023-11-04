package kanti.foodcategorychip

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.chip.Chip

class FoodCategoryChip {

	companion object {

		fun create(context: Context, root: ViewGroup? = null): Chip {
			return LayoutInflater.from(context).inflate(R.layout.chip_food_category, root) as Chip
		}

	}

}