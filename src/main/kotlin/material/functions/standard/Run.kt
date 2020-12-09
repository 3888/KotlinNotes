package material.functions.standard

import kotlin_bootcamp.aquarium.Fish

fun main() {
/*
  Run returns the result of executing the lambda
 */

    runWithObjectExample()
//    runWithoutObjectExample(100)
//    runAndLinksToFunction()

//    weNeedRunToSimplifyCode()
}

private fun runWithObjectExample() {
    val fish = Fish("Big Shark")
    println(fish.hashCode())
    val value = fish.run {
        name.contains("Shark")
        println(hashCode())
    }
    println(value)
}

private fun runWithoutObjectExample(healthPoints: Int) {
   println(if (healthPoints == 100) "perfect health" else "has injuries"
   )
}

private fun runAndLinksToFunction() {
    val result = "Madrigal".run(::nameIsShort)
    println(result)
}

private fun nameIsShort(name: String) = name.length <= 5

private fun weNeedRunToSimplifyCode() {
    println(
        playerCreateMessage(
            "Pol".run(::nameIsShort)
        )
    )

    "Polarcubi"
        .run(::nameIsShort)
        .run(::playerCreateMessage)
        .run(::println)

}

fun playerCreateMessage(nameTooLong: Boolean): String {
    return if (nameTooLong) {
        "Name is too short. Please choose another name."
    } else {
        "Welcome, adventurer"
    }
}