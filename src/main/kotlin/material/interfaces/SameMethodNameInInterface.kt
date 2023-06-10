package material.interfaces

class SameMethodNameInInterface : IA, IB {
    override fun methodWIthDefaultRealisation() {
        super<IA>.methodWIthDefaultRealisation() // Вызов метода из интерфейса A
        super<IB>.methodWIthDefaultRealisation() // Вызов метода из интерфейса B
    }
}