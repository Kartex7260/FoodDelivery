package kanti.fooddelivery

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FoodDeliveryApplication : Application(), ImageLoaderFactory {

	override fun newImageLoader(): ImageLoader = ImageLoader.Builder(this)
		.diskCache {
			DiskCache.Builder()
				.directory(
					cacheDir.resolve(Const.CACHE_FILE_NAME)
				)
				.maxSizePercent(0.01)
				.build()
		}
		.memoryCache {
			MemoryCache.Builder(this)
				.maxSizePercent(0.4)
				.build()
		}
		.build()

}