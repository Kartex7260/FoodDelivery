package kanti.fooddelivery.data.models.common

suspend fun <T> localTryCatch(block: suspend () -> LocalResult<T>): LocalResult<T> {
	return try {
		block()
	} catch (t: Throwable) {
		LocalResult(type = LocalResult.Type.Fail(t.message))
	}
}

suspend fun <T> remoteTryCatch(block: suspend () -> RemoteResult<T>): RemoteResult<T> {
	return try {
		block()
	} catch (t: Throwable) {
		RemoteResult(type = RemoteResult.Type.Fail(t.message))
	}
}