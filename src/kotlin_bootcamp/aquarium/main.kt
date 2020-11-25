package kotlin_bootcamp.aquarium

fun main(args: Array<String>) {
    buildAquarium()
}

fun buildAquarium() {
    val myAquarium = Aquarium(30, 50, 100)
    println("A standard Aquarium is :")
    println(
        "Length ${myAquarium.lengthBasic} " +
                "Width ${myAquarium.widthBasic} " +
                "Height ${myAquarium.heightBasic} "
    )

    myAquarium.heightUpdated = 80
    println("Height ${myAquarium.heightBasic} cm")
    println("Volume ${myAquarium.volumeBasic} liters")
//    myAquarium.widthUpdated = 50
//    myAquarium.lengthUpdated = 70

    println("A new Aquarium is :")
    println(
        "Length ${myAquarium.lengthUpdated} " +
                "width ${myAquarium.widthUpdated} " +
                "height ${myAquarium.heightUpdated} "
    )

    println("A new Aquarium volume is : ${myAquarium.volumeUpdated()}")

    val smallAquarium = Aquarium(20, 40, 50)
    println("smallAquarium Volume is ${smallAquarium.volumeBasic} liters")


    val aquariumWithFishes = Aquarium(35)
    println(
        "A aquariumWithFishes Volume is ${aquariumWithFishes.volumeBasic} liters" +
                "Length ${aquariumWithFishes.lengthBasic} " +
                "width ${aquariumWithFishes.widthBasic} " +
                "height ${aquariumWithFishes.heightBasic} " +
                "fishes ${aquariumWithFishes.numberOfFish}"
    )
}


