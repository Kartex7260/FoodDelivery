package kanti.fooddelivery.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import kanti.fooddelivery.R
import kanti.fooddelivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var viewBinding: ActivityMainBinding

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