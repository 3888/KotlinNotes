import java.io.File

/*
https://www.baeldung.com/kotlin/write-file
https://www.baeldung.com/kotlin/read-file
* */

private const val FILE_NAME_INPUT = "input.txt"
private const val FILE_NAME_OUTPUT = "output.txt"

fun main(args: Array<String>) {
    val content = getFileContentToString(FILE_NAME_INPUT)
    val splitIndex = content.indexOf(" ")
    val a = content.take(splitIndex).toLong()
    val b = content.substring(splitIndex + 1, content.length).toLong()

    writeTextToFile((a + b).toString(), FILE_NAME_OUTPUT)
}

private fun example1(){
    val input = readLine()!!
    createTxtFile(FILE_NAME_INPUT)
    writeTextToFile(input, FILE_NAME_INPUT)

    val content = getFileContentToString(FILE_NAME_INPUT)


    val splitIndex = content.indexOf(" ")
    val a = content.take(splitIndex).toLong()
    val b = content.substring(splitIndex + 1, content.length).toLong()

    createTxtFile(FILE_NAME_OUTPUT)
    writeTextToFile((a + b).toString(), FILE_NAME_OUTPUT)

}

private fun createTxtFile(filename: String) {
    File(filename).printWriter()
}

private fun readAndPrintFileContent(filename: String) {
    File(filename).forEachLine {
        println(it)
    }
}

private fun getFileContentToString(filename: String): String {
    var content = ""
    File(filename).forEachLine {
        content = it
    }
    return content
}

private fun writeTextToFile(text: String, filename: String) {
    File(filename).writeText(text)
}


