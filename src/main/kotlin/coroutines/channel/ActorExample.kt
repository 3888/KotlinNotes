@file:OptIn(ObsoleteCoroutinesApi::class, DelicateCoroutinesApi::class)

package coroutines.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.channels.actor

fun main() {
//    simpleActorExample(10, 1..10)
    delegatedActorExample()
}

private fun simpleActorExample(capacity: Int, range: IntRange) {
    val actor = GlobalScope.actor<String>(
        onCompletion = CompletionHandler,
        capacity = capacity
    ) {
        for (data in channel) {
            println("actor received $data")
        }
    }

    (range).forEach {
        println("iterate $it")
        if (it == range.toList().size) {
            println("Actor is closed")
            actor.close()
        }
        actor.trySend("i = $it")
    }
    Thread.sleep(700)
}

private fun delegatedActorExample() {
    val items = listOf(
        RobotPackage(1, "coffee"),
        RobotPackage(2, "chair"),
        RobotPackage(3, "sugar"),
        RobotPackage(4, "t-shirts"),
        RobotPackage(5, "pillowcases"),
        RobotPackage(6, "cellphones"),
        RobotPackage(7, "skateboard"),
        RobotPackage(8, "cactus plants"),
        RobotPackage(9, "lamps"),
        RobotPackage(10, "ice cream"),
        RobotPackage(11, "rubber duckies"),
        RobotPackage(12, "blankets"),
        RobotPackage(13, "glass")
    )

    val initialRobot = WarehouseRobot(1, items)
//    initialRobot.organizeItems()
    initialRobot.organizeItemsInParallel()
    Thread.sleep(5000)
}

object CompletionHandler : CompletionHandler {
    override fun invoke(cause: Throwable?) {
        println("Completed!")
    }
}

data class RobotPackage(val id: Int, val name: String)

class WarehouseRobot(
    private val id: Int,
    private var packages: List<RobotPackage>
) {
    companion object {
        private const val ROBOT_CAPACITY = 3
    }

    private fun processItems(items: List<RobotPackage>) {
        val actor = GlobalScope.actor<RobotPackage>(
            capacity = ROBOT_CAPACITY
        ) {
            var hasProcessedItems = false
            while (packages.isNotEmpty()) {
                val currentPackage: RobotPackage? = tryReceive().getOrNull()

                currentPackage?.run {
                    organize(this)
                    packages -= currentPackage
                    hasProcessedItems = true
                }

                if (hasProcessedItems && currentPackage == null) {
                    cancel()
                }
            }
        }

        items.forEach { actor.trySend(it) }
    }

    private fun organize(warehousePackage: RobotPackage) = println(
        "Organized package " +
                "${warehousePackage.id}:" +
                warehousePackage.name
    )

    fun organizeItems() {
        val itemsToProcess = packages.take(ROBOT_CAPACITY)
        val leftoverItems = packages.drop(ROBOT_CAPACITY)
        packages = itemsToProcess
        val packageIds = packages.map { it.id }
            .fold("") { acc, item -> "$acc$item " }
        processItems(itemsToProcess)
        if (leftoverItems.isNotEmpty()) {
            GlobalScope.launch {
                val helperRobot = WarehouseRobot(id.inc(), leftoverItems)
                helperRobot.organizeItems()
            }
        }

        println("Robot #$id processed following packages:$packageIds")
    }

    fun organizeItemsInParallel() {
        val itemsToProcess = packages.take(ROBOT_CAPACITY)
        val leftoverItems = packages.drop(ROBOT_CAPACITY)
        packages = itemsToProcess
        val packageIds = packages.map { it.id }
            .fold("") { acc, item -> "$acc$item " }

        if (leftoverItems.isNotEmpty()) {
            GlobalScope.launch {
                val helperRobot = WarehouseRobot(id.inc(), leftoverItems)
                helperRobot.organizeItemsInParallel()
            }
        }

        processItems(itemsToProcess)

        println("Robot #$id processed following packages:$packageIds")
    }
}










