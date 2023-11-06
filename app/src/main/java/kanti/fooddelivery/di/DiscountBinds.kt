package kanti.fooddelivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.fooddelivery.data.models.discounts.DiscountRepository
import kanti.fooddelivery.data.models.discounts.DiscountRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DiscountBinds {

	@Binds
	@Singleton
	fun bindDiscountRepositoryImpl(repository: DiscountRepositoryImpl): DiscountRepository

}