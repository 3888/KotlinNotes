package bootcamp

fun main(args: Array<String>) {

    swim()
    swim("slow")
    swim(speed = "like a fish")
    swimToADistance(50, "fast")

    shouldChangeWater("Today", 20, 50)
    shouldChangeWater("Today")
    shouldChangeWater("Today", dirty = 50)

    if (iShouldChangeWater("Sunday", 1, 1)) {
        println("Just Change Water!")
    }


}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun swimToADistance(distance: Int, speed: String = "fast") {
    println("swimming $speed for a $distance meters")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20) {}

fun getDirtySensorReading() = 20

fun iShouldChangeWater(day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
//    fun IsShouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {

    val isHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    println(waterFilter(dirty))
    dirtyProcessor()

    return when {
//        isHot -> true
//        isDirty -> true
//        isSunday -> true

        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

var dirty = 20

val waterFilterOne = { dirty: Int -> dirty / 2 }

val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun feedSomeFish(dirty: Int) = dirty + 10

fun updatedDirty(dirty: Int, operation: (Int) -> Int): Int {
    println("updatedDirty ${operation(dirty)}")
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updatedDirty(dirty, waterFilter)
    dirty = updatedDirty(dirty, ::feedSomeFish)

    dirty = updatedDirty(dirty) { dirty ->
        dirty + 50
    }
    dirty = updatedDirty(dirty, { dirty ->
        dirty + 50
    })

}
