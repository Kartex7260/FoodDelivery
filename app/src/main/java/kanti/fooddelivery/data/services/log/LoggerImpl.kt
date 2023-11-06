package kanti.fooddelivery.data.services.log

import android.util.Log
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {

	override fun e(tag: String?, message: String?, th: Throwable?) {
		Log.e(tag, message, th)
	}

	override fun d(tag: String?, message: String?, th: Throwable?) {
		Log.d(tag, message, th)
	}

	override fun wtf(tag: String?, message: String?, th: Throwable?) {
		Log.wtf(tag, message, th)
	}

	override fun w(tag: String?, message: String?, th: Throwable?) {
		Log.w(tag, message, th)
	}

	override fun i(tag: String?, message: String?, th: Throwable?) {
		Log.i(tag, message, th)
	}

}