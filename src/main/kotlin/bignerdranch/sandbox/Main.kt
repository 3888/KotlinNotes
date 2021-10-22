package bignerdranch.sandbox

fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(
        Fedora(
            "a generic-looking fedora",
            15
        ), Fedora(
            "a dazzling magenta fedora",
            25
        )
    )
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

//    lootBoxOne.fetch()?.run {
//        println("You retrieve $name from the box!")
//    }

    lootBoxOne.fetch(1)?.run {
        println("You retrieve $name from the box!")
    }

//    val coin = lootBoxOne.fetch {
//        Coin(it.value * 3)
//    }

    val coin = lootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }

    coin?.let { println(it.value) }


    val fedora = lootBoxOne[1]
    fedora?.let { println(it.name) }
}