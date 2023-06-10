package material.interfaces

class InterfaceImpl : IA, IB {
    override fun methodWIthDefaultRealisation() {
        println("override Реализация метода из InterfaceImpl")
    }
}