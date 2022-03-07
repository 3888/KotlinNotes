package material.loops

fun main() {
//    forInRange(1..5)
//    forInRangeUntil(1, 5)
    //    forInRangeUntil(1..5)

//    forInRangeStep(1..6, 2)
    forInDoubleStep()
//    forValueDownTo(10, 5)
}

private fun forInRange(range: IntRange) {
    for (i in range) {
        println("The range is = $range the value in range is = $i")
    }
}

private fun forInRangeUntil(start: Int, end: Int) {
    for (i in start until end) {
        println(" $i")
    }
}

private fun forInRangeStep(range: IntRange, step: Int) {
    for (i in range step step) {
        println("The range is = $range step =  $step the value in range is  = $i")
    }
}

private fun forInDoubleStep() {
    for (i in 1..10
            step 2 // делаемь шаг через 2 и устанавливаем last = 9
            step 3
    ) {
        print(i)
    }
}


private fun forValueDownTo(value: Int, downToValue: Int) {
    for (i in value downTo downToValue) {
        println("The value $value downTo $downToValue now value is = $i ")
    }
}