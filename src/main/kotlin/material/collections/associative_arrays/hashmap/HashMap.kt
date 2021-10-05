package material.collections.associative_arrays.hashmap

fun main() {

    /*
    https://bezkoder.com/kotlin-hashmap/
    */

    var bzkMap: HashMap<String, Int> = hashMapOf("zero" to 0, "onek" to 1, "twok" to 2, "bezkoder" to 9)
    println(bzkMap)

    bzkMap.put("bezkoder", 9999)
    println("After put: " + bzkMap)

    bzkMap["zero"] = 10
    println("After []: " + bzkMap)

    bzkMap.putAll(mapOf("onek" to 123, "twok" to 456))
    println("After putAll: " + bzkMap)

    println(".get " + bzkMap.get("bezkoder"))

    println("[key] " + bzkMap["bezkoder"])

    println(bzkMap.getOrElse("zkoder") { 123 })

    println(bzkMap.getOrPut("zkoder") { 123 })

    println(bzkMap.keys)
    println(bzkMap.values)

    val keys = bzkMap.filterValues { it == 9999 }.keys
    println(keys)

    bzkMap.replace("bezkoder", 8888)
    println(bzkMap)

    bzkMap.put("bezkoder", 2020)
    println(bzkMap)

    bzkMap["bezkoder"] = 9999
    println(bzkMap)

    println(bzkMap.size)
    println(bzkMap.isEmpty())
    println(bzkMap.isNotEmpty())
}