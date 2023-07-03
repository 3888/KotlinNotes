package material.reflection

import java.lang.reflect.Field

class MyClass {
    private val privateField: String = "Private Field Value"
}

fun main() {
    val obj = MyClass()

    // Получаем класс объекта
    val objClass = obj.javaClass

    // Получаем поле по имени с помощью рефлексии
    val field: Field = objClass.getDeclaredField("privateField")

    // Разрешаем доступ к приватному полю
    field.isAccessible = true

    // Получаем значение приватного поля
    val fieldValue = field.get(obj)

    // Выводим значение поля
    println(fieldValue)
}
