package material.generics.ConvarianceAndContravariance

fun main() {

}

private fun covariantArrayProblem() {
    val strs = mutableListOf<String>()
//    val objs: MutableList<Any> = strs  // Compile time Error Type mismatch
//    objs.add(1)
    val s: String = strs[0]
}

//20:00 https://www.youtube.com/watch?v=HLkjmO4_WeM
private fun smartCastError(){
    val list = mutableListOf<String>("String")
    val ints = list as MutableList<Int>
    ints.add(1)
    println(ints)

    val strs = ints as MutableList<String>
    strs.add("Three")
    println(strs)

//    val s: String = list[0] // Compile time Error Type mismatch
}


