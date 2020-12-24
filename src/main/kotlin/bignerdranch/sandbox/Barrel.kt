package bignerdranch.sandbox

//class Barrel<T>(val item: T)
//class Barrel<out T>(val item: T)
class Barrel<in T>( item: T)

fun main() {
    var fedoraBarrel: Barrel<Fedora> =
        Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

//    lootBarrel = fedoraBarrel
    fedoraBarrel = lootBarrel

//    lootBarrel.item = Coin(15)
//    val myFedora: Fedora = fedoraBarrel.item
//    val myFedora: Fedora = lootBarrel.item
}
