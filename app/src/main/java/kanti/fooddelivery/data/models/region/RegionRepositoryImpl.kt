package kanti.fooddelivery.data.models.region

import kanti.fooddelivery.data.models.common.RepositoryResult
import kanti.fooddelivery.data.models.common.toRepositoryResult
import kanti.fooddelivery.data.models.region.datasource.local.RegionLocalDataSource
import javax.inject.Inject

class RegionRepositoryImpl @Inject constructor(
	private val regionLocal: RegionLocalDataSource
) : RegionRepository {

	override suspend fun getCurrentRegion(): RepositoryResult<Region> {
		return regionLocal.getCurrentRegion().toRepositoryResult()
	}
}