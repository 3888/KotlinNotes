package bootcamp.aquarium.buildings


sealed class BaseBuildingMaterial(open val numberNeed: Int = 1)

internal class Wood : BaseBuildingMaterial() {
    override val numberNeed: Int = 4
}

internal class Brick : BaseBuildingMaterial() {
    override val numberNeed: Int = 8
}

internal class Building<out T : BaseBuildingMaterial>(buildingMaterial: T) {
    var actualMaterialsNeeded: Int = buildingMaterial.numberNeed

    fun build() {
        println("type: ${this::class.simpleName}.materials needed: $actualMaterialsNeeded")
    }
}

internal fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>): String {
    return if (building.actualMaterialsNeeded < 500) "small building" else "large building"
}