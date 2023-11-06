package kanti.fooddelivery.ui.common.errorprovider

import android.view.View
import android.widget.Button
import android.widget.TextView

interface ErrorViewOwner {

	val root: View
	val message: TextView
	val button: Button

	fun show(
		message: String = "",
		buttonText: String = "",
		callback: () -> Unit
	) {
		this.message.text = message
		button.text = buttonText
		button.setOnClickListener { callback() }
		root.visibility = View.VISIBLE
	}

	fun hide() {
		root.visibility = View.GONE
		this.message.text = ""
		button.text = ""
		button.setOnClickListener(null)
	}

}