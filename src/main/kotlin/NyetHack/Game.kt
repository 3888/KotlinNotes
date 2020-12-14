package NyetHack

fun main(args: Array<String>) {
//    var currentRoom: Room = Room("Foyer")
//    println(currentRoom.description())
//    println(currentRoom.load())


//    var townSquare: TownSquare = TownSquare()
//    println(townSquare.description())
//    println(townSquare.load())


    checkClassName()

}


private fun checkClassName(){
    var townSquare = TownSquare()
    var className = when(townSquare) {
        is TownSquare -> "TownSquare"
        is Room -> "Room"
        else -> throw IllegalArgumentException()
    }
    println(className)


    var townSquare2 = TownSquare()
    var className2 = when(townSquare) {
        is Room -> "Room"
        is TownSquare -> "TownSquare"
        else -> throw IllegalArgumentException()
    }
    println(className2)
}