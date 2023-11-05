package kanti.fooddelivery.ui.fragments.screens.foodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kanti.fooddelivery.data.models.discounts.Discount
import kanti.fooddelivery.data.models.food.Food
import kanti.fooddelivery.databinding.FragmentFoodListBinding
import kanti.fooddelivery.ui.view.foodcategories.FoodCategoryChip
import kanti.fooddelivery.ui.view.recycleradapters.DiscountRecyclerAdapter
import kanti.fooddelivery.ui.view.recycleradapters.FoodItemRecyclerAdapter

class FoodListScreenFragment : Fragment() {

	private var _viewBinding: FragmentFoodListBinding? = null
	private val viewBinding: FragmentFoodListBinding get() = _viewBinding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		if (_viewBinding == null) {
			_viewBinding = FragmentFoodListBinding.inflate(inflater, container, false)
		}
		return viewBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewBinding.apply {
			for (i in 0..4) {
				val chip = FoodCategoryChip.create(requireContext()).apply {
					text = "Test text"
				}
				if (i == 0) {
					chip.isChecked = true
				}
				foodCategoriesChipGroup.addView(chip)
			}

			foodListRecyclerView.adapter = FoodItemRecyclerAdapter(
				listOf(
					Food(
						title = "Pizza",
						composition = "Тесто, мука, яблоки, агуша",
						minPrice = 350,
						imageUrl = "",
						foodType = 0
					),
					Food(
						title = "Роллы",
						composition = "ЛА ла  ла ллла фва ы  впь лыоууоыаоы олоуал оылуоало лыуа",
						minPrice = 50000,
						imageUrl = "",
						foodType = 0
					),
					Food(
						title = "Филадельфия",
						composition = "Лл фыл ллыа флыалл лфыылалфыл флыал лфыа лыфлл алфылал лфыла лфыла ",
						minPrice = -2,
						imageUrl = "",
						foodType = 0
					),
					Food(
						title = "Салями",
						composition = "ЛАлвлф вллыв узу й9к893 9 гк9фгу к",
						minPrice = 350,
						imageUrl = "",
						foodType = 0
					),
					Food(
						title = "",
						composition = "",
						minPrice = 350,
						imageUrl = "",
						foodType = 0
					),
					Food(
						title = "",
						composition = "",
						minPrice = 350,
						imageUrl = "",
						foodType = 0
					),
					Food(
						title = "",
						composition = "",
						minPrice = 350,
						imageUrl = "",
						foodType = 0
					),
					Food(
						title = "",
						composition = "",
						minPrice = 350,
						imageUrl = "",
						foodType = 0
					)
				)
			) { _, _ -> }

			discountsRecyclerView.adapter = DiscountRecyclerAdapter(
				listOf(
					Discount(""),
					Discount(""),
					Discount(""),
					Discount("")
				)
			) { _, _ -> }
		}
	}

}