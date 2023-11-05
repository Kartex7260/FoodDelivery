package kanti.fooddelivery.data.models.common

data class RemoteResult<T>(
	val value: T? = null,
	val type: Type = Type.Success
) {
	sealed class Type(val message: String? = null) {
		data object Success : Type()
		sealed class NoConnection(message: String? = null) : Type(message)
		sealed class NoAuthorization(message: String? = null) : Type(message)
		sealed class Fail(message: String? = null) : Type(message)
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