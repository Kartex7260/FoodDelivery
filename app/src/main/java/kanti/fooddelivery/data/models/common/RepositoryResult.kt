package kanti.fooddelivery.data.models.common

data class RepositoryResult<T>(
	val value: T? = null,
	val type: Type = Type.SuccessRemote
) {
	sealed class Type(val message: String? = null) {
		data object SuccessRemote : Type()
		data object SuccessLocal : Type()
		class NoConnection(message: String? = null) : Type(message)
		class NoAuthorization(message: String? = null) : Type(message)
		class Fail(message: String? = null) : Type(message)
	}
}