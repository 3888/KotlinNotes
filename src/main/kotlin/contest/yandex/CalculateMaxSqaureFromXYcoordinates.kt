fun main() {
//    val sc = Scanner(System.`in`)
//
//    val sizeInput = sc.nextLine().split(" ")
//    val h = sizeInput[0].toInt()
//    val w = sizeInput[1].toInt()
//
//    val horizontalLinesY = sc.nextLine().split(" ").let {
//        val array = IntArray(it.size)
//        for (i in 0 until it.size) {
//            array[i] = it[i].toInt()
//        }
//        array
//    }
//
//    val verticalLinesX = sc.nextLine().split(" ").let {
//        val array = IntArray(it.size)
//        for (i in 0 until it.size) {
//            array[i] = it[i].toInt()
//        }
//        array
//    }
//
    val area = maxArea()
    println(area);
}

private fun maxArea(
    h: Int = 5,
    w: Int = 4,
    horizontalLinesY: IntArray = intArrayOf(3, 2, 1),
    verticalLinesX: IntArray = intArrayOf(2, 3)
): Long {
    val maxSize = if (h > w) h else w
    var maxSquareX = 0
    var maxSquareY = 0

    for (i in horizontalLinesY) {
        for (j in verticalLinesX) {
            if (i * j in (maxSquareY + 1) until maxSize) maxSquareY = i * j
        }
    }

    for (i in verticalLinesX) {
        for (j in horizontalLinesY) {
            if (i * j in (maxSquareX + 1) until maxSize) maxSquareX = i * j
        }
    }

    return if (maxSquareY > maxSquareX) maxSquareY * 1L else maxSquareX * 1L
}