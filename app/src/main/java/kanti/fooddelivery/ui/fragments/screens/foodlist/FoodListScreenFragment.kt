package kanti.fooddelivery.ui.fragments.screens.foodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kanti.fooddelivery.databinding.FragmentFoodListBinding

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

			}
		}
	}

}