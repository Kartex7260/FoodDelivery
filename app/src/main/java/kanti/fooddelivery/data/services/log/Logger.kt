package kanti.fooddelivery.data.services.log

interface Logger {

	fun e(tag: String? = null, message: String? = null, th: Throwable? = null)

	fun d(tag: String? = null, message: String? = null, th: Throwable? = null)

	fun wtf(tag: String? = null, message: String? = null, th: Throwable? = null)

	fun w(tag: String? = null, message: String? = null, th: Throwable? = null)

	fun i(tag: String? = null, message: String? = null, th: Throwable? = null)

}