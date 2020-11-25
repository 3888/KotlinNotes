package material.comparingJavaAndKotlin

class UserKotlin(var email: String, val isOpen: Boolean = true) {
    var isOpenBy: String = "Me"
        /*Getters and Setters*/
        get() = "$field now"
        set(value) {
            field = "$value just"
        }
}