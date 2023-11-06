package kanti.fooddelivery.ui.common.errorprovider

import androidx.fragment.app.Fragment

var Fragment.errorProvider: ErrorProvider?
	get() {
		if (activity == null || activity !is ErrorProviderOwner)
			return null
		return (activity as ErrorProviderOwner).errorProvider
	}
	set(value) {
		val activity = requireActivity()
		if (activity !is ErrorProviderOwner)
			throw IllegalStateException("Activity not implementation ErrorProviderOwner")
		(activity as ErrorProviderOwner).errorProvider = value
	}