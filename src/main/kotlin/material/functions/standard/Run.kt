package material.functions.standard

import bootcamp.aquarium.Fish

fun main() {
/*
  Run returns the result of executing the lambda
 */

//    runWithObjectExample()
//    runWithoutObjectExample(100)
//    runAndLinksToFunction()

    weNeedRunToSimplifyCode()
}

private fun runWithObjectExample() {
    val fish = Fish("Big Shark")
    println("Fish hashCode ${fish.hashCode()}")
    val value = fish.run {
        println("Fish hashCode ${fish.hashCode()}")
        name.contains("Shark")
    }
    println(value)
}

private fun runWithoutObjectExample(healthPoints: Int) {
    val status = run {
        if (healthPoints == 100) "perfect health" else "has injuries"
    }
    println(status)
}

private fun runAndLinksToFunction() {
    println("Madrigal".run(::nameIsShort)) // true
    println("Polarcubis, Supreme Master of NyetHack".run(::nameIsLong)) // false
}

private fun nameIsLong(name: String) = name.length >= 20
private fun nameIsShort(name: String) = name.length <= 5

private fun weNeedRunToSimplifyCode() {
    println(
        playerCreateMessage(
            nameIsShort("Pol")
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