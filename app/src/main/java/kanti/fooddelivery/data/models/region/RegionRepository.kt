package kanti.fooddelivery.data.models.region

import kanti.fooddelivery.data.models.common.RepositoryResult

interface RegionRepository {

	suspend fun getCurrentRegion(): RepositoryResult<Region>

}