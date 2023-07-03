package material.functions.local

fun main() {
//    saveUser(User(0, "Name", "Address"))
    User(1, "Name1", "Address1").validateBeforeSave()
}

private fun saveUser(user: User) {
    fun validateLocalFunction(
        user: User,
        value: String?,
        fieldName: String
    ) {
        if (value.isNullOrEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id} : empty $fieldName"
            )
        }
    }
    validateLocalFunction(user, user.name, "Name")
    validateLocalFunction(user, user.address, "Address")
    validateLocalFunction(user, null, "Error")
}

class User(
    val id: Int, val name: String?,
    val address: String
)

fun User.validateBeforeSave() {
    fun validate(
        value: String?,
        fieldName: String
    ) {
        if (value.isNullOrEmpty()) {
            throw IllegalArgumentException(
                "Can't save user $id: empty $fieldName"
            )
        }
    }
    validate(name, "Name")
    validate(address, "Address")
    validate(null, "Error")

    fun saveUserExt(user: User) {
        user.validateBeforeSave()
    }
}