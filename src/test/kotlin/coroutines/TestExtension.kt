package coroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*

/**
 * Convenience method for calling [runBlockingTest]
 * on an existing [TestCoroutineScope].
 *
 *
 */

@ExperimentalCoroutinesApi // Since 1.2.1, tentatively till 1.3.0
public fun TestCoroutineScope.runBlockingTest(
    block: suspend TestCoroutineScope.() -> Unit) =
    runBlockingTest(coroutineContext, block)