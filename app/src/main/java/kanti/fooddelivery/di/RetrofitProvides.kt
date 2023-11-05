package kanti.fooddelivery.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanti.fooddelivery.Const
import kanti.fooddelivery.data.models.food.datasources.remote.FoodService
import kanti.fooddelivery.data.models.foodcategories.datasource.remote.FoodCategoryService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitProvides {

	@Provides
	@Singleton
	fun provideRetrofit(): Retrofit = Retrofit.Builder()
		.addConverterFactory(GsonConverterFactory.create())
		.baseUrl(Const.BASE_URL)
		.client(OkHttpClient.Builder()
			.addInterceptor { chain ->
				val request = chain.request().newBuilder()
					.addHeader(
						Const.HEADER_RAPIDAPI_KEY_KEY,
						Const.HEADER_RAPIDAPI_KEY_VALUE
					)
					.addHeader(
						Const.HEADER_RAPIDAPI_HOST_KEY,
						Const.HEADER_RAPIDAPI_HOST_VALUE
					)
					.build()
				chain.proceed(request)
			}
			.build())
		.build()

	@Provides
	@Singleton
	fun provideFoodService(retrofit: Retrofit): FoodService = retrofit
		.create()

	@Provides
	@Singleton
	fun provideFoodCategoriesService(retrofit: Retrofit): FoodCategoryService = retrofit
		.create()

}