package material.intialization


fun main() {
    val customPlayer = Player("Farmer", 50, true, isImmortal = false)
    val warriorPlayer = Player("Warrior")
}

private class Player(
    _name: String,
    var healthPoints: Int,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) {
    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

//    constructor(name: String) : this(
//        name,
//        healthPoints = 100,
//        isBlessed = true,
//        isImmortal = false
//    )

    constructor(name: String) : this(name,
        healthPoints = 100,
        isBlessed = true,
        isImmortal = false) {
        if (name.toLowerCase() == "kar") healthPoints = 40 // some logic here
    }


}