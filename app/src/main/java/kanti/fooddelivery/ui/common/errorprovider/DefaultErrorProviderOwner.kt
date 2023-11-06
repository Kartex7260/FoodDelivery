package kanti.fooddelivery.ui.common.errorprovider

class DefaultErrorProviderOwner(
	private val errorViewOwner: ErrorViewOwner,
	errorProvider: ErrorProvider? = null
) : ErrorProviderOwner {

	private var _errorProvider: ErrorProvider? = errorProvider
	override var errorProvider: ErrorProvider?
		get() = _errorProvider
		set(value) {
			if (_errorProvider == value)
				return
			_errorProvider = value
			updateView()
		}

	private fun updateView() {
		if (_errorProvider == null) {
			errorViewOwner.hide()
		} else {
			errorViewOwner.show(
				message = _errorProvider!!.message,
				buttonText = _errorProvider!!.buttonText,
				callback = _errorProvider!!.callback
			)
		}
	}

}