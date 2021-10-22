package material.constants.adt.sealed

enum class StudentStatus {
    NOT_ENROLLED,
    ACTIVE,
    GRADUATED;

    var course: String? = null // Used for ACTIVE only TODO how to use it?!
}

sealed class StudentStatusSealed {
    object NotEnrolled : StudentStatusSealed()
    class Active(val course: String) : StudentStatusSealed()
    object Graduated : StudentStatusSealed()
}
