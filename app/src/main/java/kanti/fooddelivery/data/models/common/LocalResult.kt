package kanti.fooddelivery.data.models.common

data class LocalResult<T>(
	val value: T? = null,
	val type: Type = Type.Success
) {
	sealed class Type(val message: String? = null) {
		data object Success : Type()
		class Fail(message: String? = null) : Type(message)
	}
}

fun <T> LocalResult<T>.toRepositoryResult(): RepositoryResult<T> {
	return RepositoryResult(
		value,
		type.toRepositoryType()
	)
}

fun LocalResult.Type.toRepositoryType(): RepositoryResult.Type {
	return when (this) {
		is LocalResult.Type.Success -> RepositoryResult.Type.SuccessLocal
		is LocalResult.Type.Fail -> RepositoryResult.Type.Fail(message)
	}
}