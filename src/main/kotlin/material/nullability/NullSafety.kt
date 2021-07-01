package material.nullability

import kotlin.random.Random


fun main(args: Array<String>) {
//    https://kotlinlang.org/docs/reference/null-safety.html
//    https://kotlinlang.ru/docs/reference/null-safety.html

    var safeCastIsImpossible: String? = ""

//    nullableTypesAndNonNullTypes()
//    checkingForNullInConditions()

//    safeCalls()
//    safeCallsLet()
//    safeCallVsNotNull()

//    safeCast()
//    print(safeCastIsImpossible.length) // Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
//    safeCallsLetIgnoreNullCalls()

//    doubleBangOperator()

/*
Elvis operator "?:" it's like Java ternary operator
*/
//    elvisOperator()
//    elvisReturn()
    letElvis()

}

private fun nullableTypesAndNonNullTypes() {
    println("Nullable types and Non-Null Types")
    /*
    variable can be null and when you have complex data types such as a Arrays_and_Loops  by <Type ?>
*/
    val nullList: List<String?> = listOf(null, null, null)
    println(nullList)
    /*
  you can allow for the Arrays_and_Loops to be null by question mark "?" after <Type>
   */
    val nullList2: List<String>? = null
    println(nullList2)
    /*
    you can allow  both the Arrays_and_Loops or  the elements to be null
     */
    val nullList3: List<String?>? = null
    println(nullList3)

    var someString = "Kukaracha"
    val someStringSize = someString.length
    println("$someString someStringSize = $someStringSize")

    someString = getStringValue()
    println(getStringValue() + " someStringSize = ${someString.length}")

    val nullValueString: String? = getNull()

    /*
in programming slang the exclamation mark "!" is often called bang
we'll use a double bang "!!" to have a null value
     */

    try {
        println(" here is KotlinNullPointerException ${nullValueString!!.length}")
    } catch (e: Exception) {
        println(e)
    }

    /*
    error: null can not be a value of a non-null type
    */

    var rocksOne: Int = 5
//    rocksOne = null // compilation error

    var abc: String = "abc"
//    a = null // compilation error

    /*
    Use the question mark operator to indicate that variable can be null
    */

    val nullString: String? = null
    val kotlin = "Kotlin"
    println("nullString?.length = ${nullString?.length}")
    println("length = ${kotlin?.length}") // Unnecessary safe call
}

private fun checkingForNullInConditions() {
    println("Checking for null in conditions")
    var bOne: String? = null

    val l = if (bOne != null)
        println(bOne.length) else println(-1)

    val b: String? = "Kotlin"
    if (b != null && b.length > 0) {
        print("String of length ${b.length}")
    } else {
        print("Empty string")
    }
}

private fun safeCalls() {
    println("Safe calls for null value")
    val a = "Kotlin"
    val b: String? = null
    println("b is null ${b == null}, so we do safe call length = ${b?.length}")
    println("a is null ${a == null}, Unnecessary safe call length = ${a?.length}")
}

private fun safeCallsLet() {
    val beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "No input"
        }
    }

    println(beverage)
}

private fun safeCallVsNotNull() {
    val nameFirst: String? = null
    val nameSecond: String? = null

    if (nameFirst != null) {
        nameFirst.capitalize()
    }

    nameSecond?.capitalize()

    println(nameFirst)
    println(nameSecond)
}

private fun safeCallsLetIgnoreNullCalls() {
    println(".let{...} ignore null calls")
    val listWithNulls: List<String?> = listOf("Kotlin", null)
    listWithNulls.forEachIndexed { index, item ->
        println("index = $index")
        print("value is ")
        item?.let {
            println(it)
        } // prints Kotlin and ignores null
    }
}

private fun doubleBangOperator() {
    val b: String? = null
    val l = b!!.length
    println(l)
}

private fun safeCast() {
    val abc: String = "abc"
    val aInt: Int? = abc as? Int
    println(aInt)
}

private fun collectionsOfNullableType() {
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()

}

private fun getStringValue(): String {
    return "Hello"
}

private fun getNull(): String? {
    return null
}

private fun elvisOperator() {
//    val testValue = ""
    val testValue = null
    val name = testValue ?: "new name"
    println("testValue = $testValue")
    println(name)

    val b: String? = null

    val lJavaWay: Int = if (b != null) b.length else -1
    val lWithElvis = b?.length ?: -1

    println("lJavaWay $lJavaWay")
    println("lJavaWay $lWithElvis")
}

private fun elvisReturn() {
    val i = Random.nextInt(0, 3)
    val index = if (i < 2) {
        null
    } else i

    println("index = $index")
    index ?: return
    println("Result is OK")
}

private fun letElvis() {
    var beverage: String? = null
    beverage?.let {
        beverage = it.capitalize()
    } ?: println("I can't do that without crashing - beverage was null!")
}

