package kanti.fooddelivery.data.models.region.datasource.local

import kanti.fooddelivery.data.models.common.LocalResult
import kanti.fooddelivery.data.models.region.Region

interface RegionLocalDataSource {

	suspend fun getCurrentRegion(): LocalResult<Region>

}