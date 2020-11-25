package coursecraVvedenieVYazykKotlin

import kotlin.math.pow
import kotlin.math.sqrt


fun main() {
    val x1 = 0.0
    val y1 = 0.0
    val r1 = 1.0
    val x2 = 10.0
    val y2 = 10.0
    val r2 = 9.0

// false   0.0, 0.0, 6.0, 0.0, 0.0, 5.0
// false   0.0, 0.0, 1.0, 10.0, 10.0, 9.0


    val d = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

    println(d)
    println(d <= r1 - r2)


}

fun timeForHalfWay() {
// 2.5
    val t1 = 1
    val v1 = 5 // s1 = 5
    val t2 = 2
    val v2 = 4 //s2 = 8
    val t3 = 3
    val v3 = 3 //s2 = 9

// S = (s1 + s2 + s3) / 2 = 5 +8 + 9 =  22 / 2 = 11
// S 1/2 = S
//    S (11) > s1 (5) -> s1 + s2

    val s1 = t1 * v1
    val s2 = t2 * v2
    val s3 = t3 * v3
    val s = (s1 + s2 + s3) / 2
    var wayValue = 0.0
    var index = 0
    val tArray = arrayOf(t1, t2, t3)
    val vArray = arrayOf(v1, v2, v3)
    val sArray = arrayOf(s1, s2, s3)
    var halfTime = 0.0


    while (wayValue < s) {
        wayValue += sArray[index]
        index += 1
//        println("index = $index")
//        println("wayValue = $wayValue")
    }
    if (index > 0) index -= 1
//    t = s / v
    println("index = $index")
    println("vArray[index] = ${vArray[index]}")

    for (i in 0..index) {
        halfTime += tArray[i]
    }

    halfTime -= (wayValue - s) / vArray[index]

    println("halfTime = $halfTime")

}




