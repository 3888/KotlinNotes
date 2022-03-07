package contest.codewars.level8kyu

fun main() {
   println( areaOrPerimeter(3,3))

}

private fun areaOrPerimeter(l: Int, w: Int): Int = if (l == w) l * w else (l + w) * 2

