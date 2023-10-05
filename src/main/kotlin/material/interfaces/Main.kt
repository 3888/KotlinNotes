package material.interfaces

fun main(args: Array<String>) {
//example()
exampleSameMethodName()
}

private fun example() {
    val v1: IKotlinExample = A()
    val v2: IKotlinExample = B()


    v1.method()
    v1.methodWithDefaultRealization()
    v2.method()
    v2.methodWithDefaultRealization()
}

private fun exampleSameMethodName() {
    val interfaceImpl = InterfaceImpl()
    interfaceImpl.methodWIthDefaultRealisation()

    val sameMethodNameInInterface = SameMethodNameInInterface()
    sameMethodNameInInterface.methodWIthDefaultRealisation()

}

