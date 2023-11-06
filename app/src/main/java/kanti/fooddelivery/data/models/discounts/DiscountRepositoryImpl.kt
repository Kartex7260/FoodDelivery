package kanti.fooddelivery.data.models.discounts

import kanti.fooddelivery.R
import kanti.fooddelivery.data.models.common.RepositoryResult
import javax.inject.Inject

class DiscountRepositoryImpl @Inject constructor() : DiscountRepository {

	override suspend fun getDiscounts(): RepositoryResult<List<Discount>> {
		return RepositoryResult(
			value = listOf(
				Discount(
					imageUrl = R.drawable.discount_1.toString()
				),
				Discount(
					imageUrl = R.drawable.discount_1.toString()
				),
				Discount(
					imageUrl = R.drawable.discount_1.toString()
				)
			)
		)
	}
}