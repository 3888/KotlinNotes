package bignerdranch.nyethack

class Goblin(
    name: String = "Goblin",
    description: String = "A nasty-looking goblin",
    healthPoints: Int = 30
) : Monster(name, description, healthPoints) {
    override val diceCount = 2
    override val diceSides = 8

    override fun attack(opponent: Fightable): Int {
        TODO("Not yet implemented")
    }

}