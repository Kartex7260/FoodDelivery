package kanti.fooddelivery.ui.common

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import coil.request.ImageRequest
import kanti.fooddelivery.R

fun Context.imageRequest(
	lifecycleOwner: LifecycleOwner,
	imageView: ImageView,
	url: String
): ImageRequest {
	return ImageRequest.Builder(this)
		.data(url)
		.target(imageView)
		.lifecycle(lifecycleOwner)
		.memoryCacheKey(url)
		.diskCacheKey(url)
		.error(R.drawable.baseline_image_not_supported_24)
		.allowRgb565(true)
		.build()
}