package bignerdranch.nyethack

import material.Helper


interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int // default getter
        get() = (0 until diceCount).map {
            Helper.random.nextInt(diceSides + 1)
        }.sum()

    fun attack(opponent: Fightable): Int
}