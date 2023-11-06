package kanti.fooddelivery.ui.common.errorprovider

class ErrorProvider(
	val message: String,
	val callback: () -> Unit
)