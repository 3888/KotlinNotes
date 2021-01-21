package material.delegate


fun main() {
    val example = Example()

    example.param = "        123     "

    print(example.param)



}
class Example {
    var param: String by TrimDelegate()
}