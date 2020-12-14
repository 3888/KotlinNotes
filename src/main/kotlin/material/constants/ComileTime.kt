package material.constants


private const val COMPILE_TIME_CONST = 5 // top-level constant

object CompileTimeConst {
    const val CONSTANT2 = "object constant"
}


class MyClass {
    companion object {
        const val CONSTANT3 = "constant inside companion)"
    }

}
