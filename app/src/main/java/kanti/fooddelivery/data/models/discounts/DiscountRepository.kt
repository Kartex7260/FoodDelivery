package kanti.fooddelivery.data.models.discounts

import kanti.fooddelivery.data.models.common.RepositoryResult

interface DiscountRepository {

	suspend fun getDiscounts(): RepositoryResult<List<Discount>>

}