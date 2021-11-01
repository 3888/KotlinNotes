package contest

import java.util.regex.Pattern

fun main() {
//    stringToMapAndReverseToStringMy()
    stringToMapAndReverseToString()
}


private fun stringToMapAndReverseToStringMy() {
//    0=1334:5678:90%1=644:111:000//
//    сделать из нее Map<Int, List<String>> и обратно точно такой-же String
//
//    лист разделяется двоеточиями, а ключ и значение мапы через =//
//    а разные мап-энтри через %

//    assotiateXXYYYZZZ, split, map
    val task = "0=1334:5678:90%1=644:111:000"

    var key = -1
    val map = mutableMapOf<Int, List<String>>()
    var list = mutableListOf<String>()

    println("String is $task")

    task.split("=", ":", "%").map {
        if (it.length == 1) {
            list = mutableListOf()

            key = it.toInt()
        } else {
            list.add(it)
            map[key] = list
        }
    }

    println(map)

    var stringFromMap = ""

    map.forEach { (key, value) ->
        stringFromMap = "$stringFromMap$key=${value.joinToString(":") { it }}%"
    }

    println(stringFromMap.substring(0, stringFromMap.length - 1))
}

private fun stringToMapAndReverseToString() {
    val permits = "0=1334:5678:90%1=644:111:000"

 val  map =
    permits.split("%")
        .map { it.split("=") }
        .map { listOf(it.first(), it.last()) }
        .associateBy({ it.first().toInt() }, { it.last().split(":") })

    println(map)

   println(
       buildString {
        map.asIterable().forEachIndexed { index, entry ->
            append("$index=${entry.value.joinToString(":")}")
            if (index != permits.length - 1) append("%")
        }
    }
   )
}

fun CharSequence.indicesOf(input: String): List<Int> =
    Regex(Pattern.quote(input)) // build regex
        .findAll(this)          // get the matches
        .map { it.range.first } // get the index
        .toCollection(mutableListOf()) // collect the result as list