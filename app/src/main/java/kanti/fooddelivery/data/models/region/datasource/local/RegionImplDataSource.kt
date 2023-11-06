package kanti.fooddelivery.data.models.region.datasource.local

import kanti.fooddelivery.data.models.common.LocalResult
import kanti.fooddelivery.data.models.region.Region
import javax.inject.Inject

class RegionImplDataSource @Inject constructor() : RegionLocalDataSource {

	override suspend fun getCurrentRegion(): LocalResult<Region> {
		return LocalResult(
			value = Region(
				id = 0,
				name = "Москва",
				current = true
			)
		)
	}
}