package kanti.fooddelivery.data.models.common

data class RemoteResult<T>(
	val value: T? = null,
	val type: Type = Type.Success
) {
	sealed class Type(val message: String? = null) {
		data object Success : Type()
		class NoConnection(message: String? = null) : Type(message)
		class NoAuthorization(message: String? = null) : Type(message)
		class Fail(message: String? = null) : Type(message)
	}

}

fun <T> RemoteResult<T>.toRepositoryResult(): RepositoryResult<T> {
	return RepositoryResult(
		value,
		type.toRepositoryType()
	)
}

fun RemoteResult.Type.toRepositoryType(): RepositoryResult.Type {
	return when (this) {
		is RemoteResult.Type.Success -> RepositoryResult.Type.Success
		is RemoteResult.Type.NoConnection -> RepositoryResult.Type.NoConnection(message)
		is RemoteResult.Type.NoAuthorization -> RepositoryResult.Type.NoAuthorization(message)
		is RemoteResult.Type.Fail -> RepositoryResult.Type.Fail(message)
	}
}

val <T> RemoteResult<T>.isNull: Boolean get() {
	return value == null
}

val <T> RemoteResult<T>.isSuccess: Boolean get() {
	return type is RemoteResult.Type.Success
}

val <T> RemoteResult<T>.isNoConnection: Boolean get() {
	return type is RemoteResult.Type.NoConnection
}

val <T> RemoteResult<T>.isNoAuthorization: Boolean get() {
	return type is RemoteResult.Type.NoAuthorization
}

val <T> RemoteResult<T>.isFail: Boolean get() {
	return type is RemoteResult.Type.Fail
}