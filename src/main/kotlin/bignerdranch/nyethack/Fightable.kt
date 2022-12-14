package bignerdranch.nyethack

import kotlin.random.Random.Default.nextInt


interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int // default getter
        get() = (0 until diceCount).map {
            nextInt(diceSides + 1)
        }.sum()

    fun attack(opponent: Fightable): Int
}