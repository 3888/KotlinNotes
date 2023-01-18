package coroutines.testing

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import material.functions.local.User

class MainView(
    private val presenter: MainPresenter, private val contextProvider: CoroutineContextProvider,
    private val coroutineScope: CoroutineScope
) {
    var userData: User? = null

    fun fetchUserData() {
        coroutineScope.launch(contextProvider.context()) {
            userData = presenter.getUser(101)
        }
    }

    fun printUserData() {
        println(userData)
    }
}