package contest.codewars.level7kyu

object OpstringsMy {
    fun vertMirror(string: String) = string.reversed().split("\n").reversed().joinToString("") {"$it\n"}.trim()
    fun horMirror(string: String)= string.split("\n").reversed().joinToString("") {"$it\n"}.trim()
    fun oper(mirrorType: (String) -> String, s: String): String = mirrorType(s)
}

object Opstrings {
    fun vertMirror(strng: String) = strng.split("\n").joinToString("\n") { it.reversed() }
    fun horMirror(strng: String) = strng.split("\n").reversed().joinToString("\n")
    fun oper(f: (String) -> String , s: String): String = f(s)
}


