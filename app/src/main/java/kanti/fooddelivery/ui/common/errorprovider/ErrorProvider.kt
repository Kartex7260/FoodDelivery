package kanti.fooddelivery.ui.common.errorprovider

class ErrorProvider(
	val message: String,
	val buttonText: String,
	val callback: () -> Unit
)