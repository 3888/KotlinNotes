package coursecraVvedenieVYazykKotlin

import kotlin.math.PI


fun main() {
    accountInThreeYears()
}

fun angleInRadian() {
    val deg = 36
    val min = 14
    val sec = 35

    println(
        (
                (deg +
                        (min / 60) +
                        (sec / 3600)
                        )
                        * PI / 180)
    )

    println(
        (
                deg +
                        (min + sec / 60.0)
                        / 60.0)
                * PI / 180.0
    )

}

fun accountInThreeYears() {
    val years = 3
    val initial = 100
    val percent = 10
    var money = initial

    for (i in 1..years) {
        println("money = $money")

        money += (money * percent / 100)
        println("money += (money * percent / 100) = $money")
    }
}




