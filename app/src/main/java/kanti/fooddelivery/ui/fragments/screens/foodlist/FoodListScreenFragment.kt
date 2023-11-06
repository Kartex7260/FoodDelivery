package kanti.fooddelivery.ui.fragments.screens.foodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kanti.fooddelivery.data.models.common.RepositoryResult
import kanti.fooddelivery.data.models.food.Food
import kanti.fooddelivery.data.models.foodcategories.FoodCategory
import kanti.fooddelivery.databinding.FragmentFoodListBinding
import kanti.fooddelivery.ui.common.flowobserver.observe
import kanti.fooddelivery.ui.common.progressindicatorowner.requireProgressIndicator
import kanti.fooddelivery.ui.fragments.screens.foodlist.viewmodel.FoodDataUiState
import kanti.fooddelivery.ui.fragments.screens.foodlist.viewmodel.FoodListScreenViewModel
import kanti.fooddelivery.ui.view.foodcategories.FoodCategoryChip
import kanti.fooddelivery.ui.view.recycleradapters.FoodItemRecyclerAdapter

@AndroidEntryPoint
class FoodListScreenFragment : Fragment() {

	private var _viewBinding: FragmentFoodListBinding? = null
	private val viewBinding: FragmentFoodListBinding get() = _viewBinding!!

	private val viewModel: FoodListScreenViewModel by viewModels()

	private val foodListRecyclerAdapter = FoodItemRecyclerAdapter { image: ImageView, imageUrl: String ->
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewModel.getData()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		if (_viewBinding == null) {
			_viewBinding = FragmentFoodListBinding.inflate(inflater, container, false)
			viewBinding.foodListRecyclerView.adapter = foodListRecyclerAdapter
		}
		return viewBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		viewLifecycleOwner.observe(viewModel.foodUiState) { uiState ->
			showProcess(uiState.process)
			showUiStateType(uiState.type)
			showFoodData(uiState.foodData)
		}
	}

	private fun showProcess(process: Boolean) {
		requireProgressIndicator().also { progressView ->
			if (process) {
				progressView.visibility = View.VISIBLE
			} else {
				progressView.visibility = View.INVISIBLE
			}
		}
	}

	private fun showUiStateType(type: RepositoryResult.Type) {
		when (type) {
			else -> {}
		}
	}

	private fun showFoodData(foodData: FoodDataUiState) {
		foodListRecyclerAdapter.items = foodData.food
		showFoodCategories(foodData.foodCategory)
	}

	private fun showFoodCategories(list: List<FoodCategory>) {
		val chipGroup = viewBinding.foodCategoriesChipGroup
		chipGroup.removeAllViews()
		for (foodCategory in list) {
			val chip = FoodCategoryChip.create(requireContext())
			chip.text = foodCategory.name
			chipGroup.addView(chip)
		}

		if (chipGroup.childCount > 0) {
			(chipGroup[0] as Chip).isChecked = true
		}
	}

}