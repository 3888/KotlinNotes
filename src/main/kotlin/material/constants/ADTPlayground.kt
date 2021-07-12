package material.constants

import material.constants.adt.enum.Coordinate
import material.constants.adt.enum.EnumColors
import material.constants.adt.enum.EnumWithFunction
import material.constants.adt.sealed.StudentStatus
import material.constants.adt.sealed.StudentStatusSealed

fun main() {

enum()

//    println(studentMessageEnum(StudentStatus.ACTIVE))
//    println(studentMessageSealedClass(StudentStatusSealed.Active("History")))
}

private fun enum() {
    println(EnumColors.BLACK)
    println(EnumColors.BLACK.colorHex)
    println(EnumColors.BLACK.ordinal)
    println(EnumColors.BLACK.opacity)

    println(EnumColors.RED)
    println(EnumColors.RED.colorHex)
    println(EnumColors.RED.ordinal)
    println(EnumColors.RED.opacity)
}


private fun enumWithFunction() {
    println(EnumColors.BLACK.colorHex)
    println(EnumColors.BLACK.ordinal)
    println(EnumWithFunction.EAST.updateCoordinate(Coordinate(1, 1)))
    println(EnumColors.BLACK)
    println(EnumColors.BLACK.colorHex)
    println(EnumColors.BLACK.opacity)
}


private fun studentMessageEnum(status: StudentStatus): String {
    return when (status) {
        StudentStatus.NOT_ENROLLED -> "Please choose a course."
        StudentStatus.ACTIVE -> "Welcome, student!"
        StudentStatus.GRADUATED -> "Congratulations!"
    }
}

private fun studentMessageSealedClass(status: StudentStatusSealed): String {
    return when (status) {
        is StudentStatusSealed.NotEnrolled -> "Please choose a course."
        is StudentStatusSealed.Active -> "You are enrolled in: ${status.course}"
        is StudentStatusSealed.Graduated -> "Congratulations!"
    }
}
