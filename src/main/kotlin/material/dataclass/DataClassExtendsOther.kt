package material.dataclass

import java.time.LocalDateTime

/*
https://stackoverflow.com/questions/26444145/extend-data-class-in-kotlin
* */

abstract class AbstractClass {
    abstract var id: Long
    abstract var location: String
}

data class DataClassExtendsAbstractClass(
    override var id: Long = 0,
    override var location: String = "",
    var isbn: String,
) : AbstractClass()

open class OpenClass(open var id: Long = 0, open var location: String = "")

data class DataClassExtendsOpenClass(
    override var id: Long = 0,
    override var location: String = "",
    var isbn: String,
) : OpenClass()

interface Interface {
    val date: LocalDateTime
    val name: String
    val value: Int
}

data class DataClassExtendsInterface(
    override val date: LocalDateTime,
    override val name: String,
    override val value: Int,
    val fixedEvent: String,
) : Interface