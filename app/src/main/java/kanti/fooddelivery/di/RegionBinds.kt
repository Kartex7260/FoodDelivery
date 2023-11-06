package kanti.fooddelivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.fooddelivery.data.models.region.RegionRepository
import kanti.fooddelivery.data.models.region.RegionRepositoryImpl
import kanti.fooddelivery.data.models.region.datasource.local.RegionImplDataSource
import kanti.fooddelivery.data.models.region.datasource.local.RegionLocalDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RegionBinds {

	@Binds
	fun bindRegionImplDataSource(dataSource: RegionImplDataSource): RegionLocalDataSource

	@Binds
	@Singleton
	fun bindRegionRepositoryImpl(repository: RegionRepositoryImpl): RegionRepository

}