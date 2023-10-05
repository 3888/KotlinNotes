package coroutines

import coroutines.testing.CoroutineContextProviderImp
import coroutines.testing.MainPresenter
import coroutines.testing.MainPresenter.Companion.DELAY
import coroutines.testing.MainView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

@ExperimentalCoroutinesApi
internal class MainViewTest {
    // 1
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    // 2
    private val testCoroutineScope = TestCoroutineScope(testCoroutineDispatcher)

    // 3
    private val testCoroutineContextProvider = CoroutineContextProviderImp(testCoroutineDispatcher)

    // 4
    private val mainPresenter by lazy { MainPresenter() }
    private val mainView by lazy { MainView(mainPresenter, testCoroutineContextProvider, testCoroutineScope) }


    @Test
    fun testFetchUserData() = testCoroutineScope.runBlockingTest {
// initial state
        assertNull(mainView.userData)

// updating the state
        mainView.fetchUserData()

// advance the test clock
        advanceTimeBy(DELAY)

// checking the new state, and printing it out
        assertEquals("Tony Stark", mainView.userData?.name)
        mainView.printUserData()
    }

    @Test
    fun exampleTest() = runBlockingTest {
        val deferred = async {
            delay(DELAY)
            async {
                delay(DELAY)
            }.await()
        }
        deferred.await() // result available immediately
    }

}