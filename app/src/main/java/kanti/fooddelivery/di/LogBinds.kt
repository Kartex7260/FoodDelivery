package kanti.fooddelivery.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.fooddelivery.data.services.log.Logger
import kanti.fooddelivery.data.services.log.LoggerImpl

@Module
@InstallIn(SingletonComponent::class)
interface LogBinds {

	@Binds
	fun bindLoggerImpl(logger: LoggerImpl): Logger

}