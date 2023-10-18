package contest.ytilidoc.real

import material.strings.checkByRegex

fun main() {

/*
 rows are separated by new line characters ('\n')
 each row consists of one or more fields separated by commas (',')

+------+-----------+-------+---------+---------+---------+
id        name      age      act.       room      dep.
+------+-----------+-------+---------+---------+---------+
1         Jack      68        T           13        8
17       Betty      28        F           15        7
+------+----------+-------+---------+---------+---------+

 */

    solution(
//        "id,name,age,act.,room,dep.\n1,Jack,68,T,13,8\n17,Betty,28,F,15,7",
//        "age"

//        "area,land\n3722,CN\n6612,RU\n3855,CA\n3797,USA'",
//        "area"

        "city,temp2,temp\nParis,7,-3\nDubai,4,-4\nPorto,-1,-2",
        "temp"
    )
}


private fun solution(string: String, columnFilter: String): Int {
    val comma = ","
    val newLine = "*"
    val newString = "$string$newLine"
        .replace("\n", newLine)
        .replace("'", "")

    val listSorted = ArrayList<List<String>>()
    var valueTillNewLine = ""
    var singleWord = ""

    println(newString)

    for (i in newString) {
        valueTillNewLine += i
        if (i.toString() == newLine) {
//            println(valueTillNewLine)

            val words = ArrayList<String>()
            valueTillNewLine = valueTillNewLine.replace(newLine, ",")

            for (j in valueTillNewLine) {
                singleWord += j
                if (j.toString() == comma) {
                    singleWord = singleWord.replace(",", "")
//                    println(singleWord)
                    words.add(singleWord)
                    singleWord = ""
                }
            }

            listSorted.add(words)
            valueTillNewLine = ""

        }
    }

//    println(listSorted)

    val indexOfFilter = listSorted[0].indexOf(columnFilter)
//    println(indexOfFilter)

    var result = 0

    var filteredValue: String

    for (i in 1 until listSorted.size) {
        filteredValue = listSorted[i][indexOfFilter]

//        println(filteredValue)

//        println("$filteredValue  length = " + filteredValue.length)

        if (checkByRegex(filteredValue, "-?[0-9]+")) {
//        println(filteredValue)
            if (filteredValue.toInt() != 0 ) result = filteredValue.toInt()
        }
    }

    println(result)

    return result
}
