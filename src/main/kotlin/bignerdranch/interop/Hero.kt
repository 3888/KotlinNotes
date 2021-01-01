package bignerdranch.interop

import bignedranch.interop.Jhava


fun main(args: Array<String>) {
    val adversary = Jhava()
    println(Jhava().utterGreeting())

    val friendshipLevel = adversary.determineFriendshipLevel()
    println(friendshipLevel?.toLowerCase() ?: "It's complicated.")

    val adversaryHitPoints: Int = adversary.hitPoints
    println(adversaryHitPoints.dec())
}