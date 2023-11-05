package kanti.fooddelivery.ui.view.foodcategories

import android.animation.ValueAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import com.google.android.material.chip.Chip
import kanti.fooddelivery.R

object FoodCategoryChip {

	private const val animDuration = 100L

	fun create(
		context: Context,
		root: ViewGroup? = null,
		listener: CompoundButton.OnCheckedChangeListener? = null
	): Chip {
		val elevationChecked = context.resources.getDimension(R.dimen.chipFoodCategoryChecked)
		val elevationUnchecked = context.resources.getDimension(R.dimen.chipFoodCategoryUnchecked)
		return (LayoutInflater.from(context)
			.inflate(R.layout.view_food_category, root) as Chip)
			.apply {
				setOnCheckedChangeListener { buttonView, isChecked ->
					if (isChecked) {
						context.elevationAnimation(elevationUnchecked, elevationChecked) {
							elevation = it
						}
						setTextAppearance(R.style.TextAppearance_Chip_FoodCategory_Checked)
					} else {
						context.elevationAnimation(elevationChecked, elevationUnchecked) {
							elevation = it
						}
						setTextAppearance(R.style.TextAppearance_Chip_FoodCategory_Unchecked)
					}
					listener?.onCheckedChanged(buttonView, isChecked)
				}
		}
	}

	private fun Context.elevationAnimation(
		startValue: Float,
		endValue: Float,
		onUpdate: (Float) -> Unit
	) {
		ValueAnimator.ofFloat(
			startValue,
			endValue
		).apply {
			duration = animDuration
			addUpdateListener {
				onUpdate(animatedValue as Float)
			}
		}.start()
	}

}