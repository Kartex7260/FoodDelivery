package kanti.fooddelivery.ui.common.flowobserver

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.observe(
	flow: Flow<T>,
	lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
	block: (T) -> Unit
) {
	lifecycleScope.launch {
		repeatOnLifecycle(lifecycleState) {
			flow.collectLatest(block)
		}
	}
}