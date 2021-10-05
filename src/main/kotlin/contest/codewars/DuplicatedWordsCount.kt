package contest.codewars

import java.util.*

object DuplicatedWordsCount {
    @JvmStatic
    fun main(args: Array<String>) {
        // Given String containing duplicate words
        var input =
//            "Java is a programming language. Python is also a programming language."
            "[Condition(type=DOLS, test test)]"
        // Converting given String to lowerCase
        input = input.toLowerCase()
        /* Split the Input String into words using
      built-in split() method */
        val strArray = input.split(" ").toTypedArray()
        /* Declare List of String that will
      contain repeated words*/
        val repeatedWords: MutableList<String> = ArrayList()
        /* Declare HashSet of String that will
      contain unique words */
        val uniqueWords = HashSet<String>()
        for (str in strArray) {
            if (!uniqueWords.add(str)) repeatedWords.add(str)
        }
        println(repeatedWords.size)
    }
}