package material.generics


open class WaterSupply(var needsProcessed: Boolean) {
    class TapWater : WaterSupply(true) {
        fun addChemicalCleaners() {
            needsProcessed = false
        }
    }
}

fun main() {
//    genericExample()
    genericExampleAquarium()
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class AquariumGenericType<T>(val waterSupply: T)

class AquariumGenericAnyWithNull<T : Any?>(val waterSupply: T)

class AquariumGenericTypeAnyNullIsImpossible<T : Any>(val waterSupply: T)

class AquariumGenericWaterSupply<out T : WaterSupply>(val watterSupply: T) {

    fun addWater() {
        check(!watterSupply.needsProcessed) { "Water supply needs processed" }
        println("adding water from $watterSupply")
    }

    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = watterSupply is R
    inline fun <reified R : WaterSupply> AquariumGenericWaterSupply<WaterSupply>.hasWaterSupplyOfType2() =
        watterSupply is R

    inline fun <reified R : WaterSupply> AquariumGenericWaterSupply<*>.hasWaterSupplyOfTypeAnyTypeAstriх() =
        watterSupply is R
}

fun isWaterClean(aquarium: AquariumGenericWaterSupply<WaterSupply>) {
    println("aquarium watter is clean: ${aquarium.watterSupply.needsProcessed}")
}

fun <T : WaterSupply> isWaterCleanWithType(aquarium: AquariumGenericWaterSupply<T>) {
    println("aquarium watter is clean: ${aquarium.watterSupply.needsProcessed}")


}

fun genericExampleAquarium() {
    val aquariumLakeWater = AquariumGenericWaterSupply(LakeWater())
//    aquariumLakeWater.addWater() // IllegalStateException

    aquariumLakeWater.watterSupply.filter()
    aquariumLakeWater.addWater()

    val aquariumTapWater = AquariumGenericWaterSupply(WaterSupply.TapWater())
    isWaterClean(aquariumTapWater)
}

fun genericExample() {
    val aquarium = AquariumGenericType<WaterSupply.TapWater>(WaterSupply.TapWater())
    aquarium.waterSupply.addChemicalCleaners()
    println("<T>  ${aquarium.waterSupply}")

    val aquariumString = AquariumGenericType<String>("string")
    println("<String>  ${aquariumString.waterSupply}")

    val aquariumNull = AquariumGenericType<Nothing?>(null) // by default T stands for the nullable and type
    println("<Nothing?>  ${aquariumNull.waterSupply}")

    val aquariumNull2 = AquariumGenericAnyWithNull<Nothing?>(null) // by default T stands for the nullable and type
    println("<Nothing?>  ${aquariumNull.waterSupply}")

//    val aquariumNoNull = AquariumGenericTypeAnyNullIsImpossible<Nothing?>(null) // error

//    val aquariumWaterSupply = AquariumGenericWaterSupply ("String") // error
}
