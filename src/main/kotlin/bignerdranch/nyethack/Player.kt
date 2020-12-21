package bignerdranch.nyethack

import java.io.File

class Player(
    _name: String,
    override var healthPoints: Int = 100,
    var isBlessed: Boolean,
    private val isImmortal: Boolean
) : Fightable {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown = selectHometown()
    var currentPosition = Coordinate(0, 0)

    init {
        require(this.healthPoints > 0) { "HP must be above zero!" }
        require(name.isNotBlank()) { "Our hero must have a name assigned!" }
    }

    constructor(name: String) : this(
        name,
        healthPoints = 100,
        isBlessed = true,
        isImmortal = false
    ) {
        this.name = name
        if (name.toLowerCase() == "kar") this.healthPoints = 40
    }

    fun castFireball(numFireballs: Int = 2) {
        println("Casting fireball spell. You have $numFireballs shots")
    }

    fun auraColor(): String {
        val auraVisible = isBlessed && this.healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus(name: String): String {
        print(name)
        return if (name.isNotEmpty()) {
            when (this.healthPoints) {
                100 -> "is in excellent condition!"
                in 75..99 -> "has a few minor cuts and bruises here and there."
                in 50..74 -> if (isBlessed) {
                    "has some lacerations, but is rapidly recovering"
                } else {
                    "has some lacerations and potentially internal bleeding."
                }
                in 25..49 -> "is hemorrhaging blood and has multiple fractures. Seek medical attention immediately!"
                else -> "has ruptured organs and is bordering on shock. I hope you wrote your will..."
            }
        } else {
            "Error"
        }
    }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()


    override val diceCount: Int = 6
    override val diceSides: Int = 2

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }
}