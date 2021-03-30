package material.constants

import material.constants.enum.Coordinate
import material.constants.enum.EnumWithFunction

fun main() {

//    println(EnumColors.BLACK.colorHex)
//    println(EnumColors.BLACK.ordinal)

    println(EnumWithFunction.EAST.updateCoordinate(Coordinate(1, 1)))


}