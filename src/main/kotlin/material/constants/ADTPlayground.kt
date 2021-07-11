package material.constants

import material.constants.adt.sealed.StudentStatus
import material.constants.adt.sealed.StudentStatusSealed

fun main() {

//    println(EnumColors.BLACK.colorHex)
//    println(EnumColors.BLACK.ordinal)

//    println(EnumWithFunction.EAST.updateCoordinate(Coordinate(1, 1)))

    println(studentMessageEnum(StudentStatus.ACTIVE))
    println(studentMessageSealedClass(StudentStatusSealed.Active("History")))
}

private fun studentMessageEnum(status: StudentStatus): String {
    return when (status) {
        StudentStatus.NOT_ENROLLED -> "Please choose a course."
        StudentStatus.ACTIVE -> "Welcome, student!"
        StudentStatus.GRADUATED -> "Congratulations!"
    }
}

fun studentMessageSealedClass(status: StudentStatusSealed): String {
    return when (status) {
        is StudentStatusSealed.NotEnrolled -> "Please choose a course."
        is StudentStatusSealed.Active -> "You are enrolled in: ${status.course}"
        is StudentStatusSealed.Graduated -> "Congratulations!"
    }
}
