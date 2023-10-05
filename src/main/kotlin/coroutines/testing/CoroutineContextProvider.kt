package coroutines.testing

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    fun context(): CoroutineContext
}