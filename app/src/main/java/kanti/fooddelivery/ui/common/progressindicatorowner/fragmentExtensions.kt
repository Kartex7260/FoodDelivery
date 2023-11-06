package kanti.fooddelivery.ui.common.progressindicatorowner

import androidx.fragment.app.Fragment
import com.google.android.material.progressindicator.CircularProgressIndicator

val Fragment.progressIndicator: CircularProgressIndicator? get() {
	if (activity == null || activity !is CircularProgressIndicatorOwner)
		return null
	return (activity as CircularProgressIndicatorOwner).circularProgressIndicator
}

fun Fragment.requireProgressIndicator(): CircularProgressIndicator {
	val activity = requireActivity()
	if (activity !is CircularProgressIndicatorOwner)
		throw IllegalStateException("Activity not implementation CircularProgressIndicatorOnwer")
	return (activity as CircularProgressIndicatorOwner).circularProgressIndicator
}