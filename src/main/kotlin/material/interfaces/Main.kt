package material.interfaces

fun main(args: Array<String>) {

    var v1: IKotlinExample = A()
    var v2: IKotlinExample = B()


    v1.method()
    v1.methodWithDefaultRealization()
    v2.method()
    v2.methodWithDefaultRealization()
}