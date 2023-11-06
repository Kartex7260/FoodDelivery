package kanti.fooddelivery.ui.common.errorprovider

import android.view.View
import android.widget.Button
import android.widget.TextView

abstract class ErrorViewOwner {

	abstract val root: View
	abstract val message: TextView
	abstract val button: Button

	fun show(
		message: String = "",
		callback: () -> Unit
	) {
		this.message.text = message
		button.setOnClickListener { callback() }
		root.visibility = View.VISIBLE
	}

	fun hide() {
		root.visibility = View.GONE
		this.message.text = ""
		button.setOnClickListener(null)
	}

}