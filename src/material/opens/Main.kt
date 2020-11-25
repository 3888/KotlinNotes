package material.opens

fun main(args: Array<String>) {

    val person = Person("Alex")
    val driver = Driver("Pupkin")

    println(person.toString())
    person.getPhoneOpen()
    person.getPhoneNotOpen()


    println(driver.toString())
    driver.getPhoneOpen()
    driver.getPhoneNotOpen()


}

