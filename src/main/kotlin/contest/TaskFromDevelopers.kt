package contest

import java.util.regex.Pattern

fun main() {
    stringToMapAndReverseToString()

}


private fun stringToMapAndReverseToString() {
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

fun CharSequence.indicesOf(input: String): List<Int> =
    Regex(Pattern.quote(input)) // build regex
        .findAll(this)          // get the matches
        .map { it.range.first } // get the index
        .toCollection(mutableListOf()) // collect the result as list