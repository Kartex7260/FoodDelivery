package kanti.fooddelivery.data.models.common

suspend fun <T> localTryCatch(block: suspend () -> LocalResult<T>): LocalResult<T> {
	return try {
		block()
	} catch (t: Throwable) {
		LocalResult(type = LocalResult.Type.Fail("localTryCatch ${t.javaClass.simpleName}:  ${t.message}"))
	}
}

suspend fun <T> remoteTryCatch(block: suspend () -> RemoteResult<T>): RemoteResult<T> {
	return try {
		block()
	} catch (t: Throwable) {
		RemoteResult(type = RemoteResult.Type.Fail("remoteTryCatch ${t.javaClass.simpleName}: ${t.message}"))
	}
}