package kanti.fooddelivery.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.progressindicator.CircularProgressIndicator
import dagger.hilt.android.AndroidEntryPoint
import kanti.fooddelivery.R
import kanti.fooddelivery.databinding.ActivityMainBinding
import kanti.fooddelivery.ui.common.errorprovider.DefaultErrorProviderOwner
import kanti.fooddelivery.ui.common.errorprovider.ErrorProvider
import kanti.fooddelivery.ui.common.errorprovider.ErrorProviderOwner
import kanti.fooddelivery.ui.common.errorprovider.ErrorViewOwner
import kanti.fooddelivery.ui.common.progressindicatorowner.CircularProgressIndicatorOwner

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CircularProgressIndicatorOwner, ErrorProviderOwner,
ErrorViewOwner {

	override val root: View
		get() = viewBinding.root.findViewById(R.id.errorRoot)
	override val message: TextView
		get() = viewBinding.root.findViewById(R.id.errorMessageTextView)
	override val button: Button
		get() = viewBinding.root.findViewById(R.id.errorButtonCallback)

	private val defaultErrorProviderOwner = DefaultErrorProviderOwner(this)


	private lateinit var viewBinding: ActivityMainBinding

	override val circularProgressIndicator: CircularProgressIndicator
		get() = viewBinding.progressView

	override var errorProvider: ErrorProvider?
		get() = defaultErrorProviderOwner.errorProvider
		set(value) {
			defaultErrorProviderOwner.errorProvider = value
		}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(viewBinding.root)

		viewBinding.bottomNavigation.setOnItemSelectedListener { menuItem ->
			val navController = findNavController(R.id.fragmentContainerNav)
			menuItem.onNavDestinationSelected(navController)
		}
	}
}