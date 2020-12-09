package coursecraVvedenieVYazykKotlin

fun main() {
    println(isCoPrime(50,10))
}

fun isCoPrime(m: Int, n: Int): Int {
    var a = m
    var b = n

    while (b != 0) {
        val tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
}