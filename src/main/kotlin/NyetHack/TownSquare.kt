package NyetHack

class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3

    private var bellSound = "GWONG"

    override fun load() = "The villagers rally and cheer as you enter! n${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}