package coroutines.testing

import kotlinx.coroutines.delay
import material.functions.local.User

class MainPresenter {
    suspend fun getUser(userId: Int): User {
        delay(DELAY)
        return User(userId, "Tony Stark", "Earth")
    }

    companion object {
        const val DELAY = 1000L
    }
}