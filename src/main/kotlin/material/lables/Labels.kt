package material.lables

fun main() {
    loop@ for (i in 1..10) {
        println("i = $i")
        for (j in 1..3) {
            println("j = $j")
            if (i >= 3) break@loop
        }
    }
}