package bignerdranch.sandbox

class Barrel<T>(var item: T)
//class Barrel<T>(val item: T)
//class Barrel<out T>(val item: T)
//class Barrel<in T>( item: T)

fun main() {
    var fedoraBarrel: Barrel<Fedora> =
        Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

//    lootBarrel = fedoraBarrel // ERROR Type mismatch.
    /*
    при этом Loot вполне можно присвоить экземпляр Fedora
     */
    var loot: Loot = Fedora("a generic-looking fedora", 15) // Нет ошибки

//    fedoraBarrel = lootBarrel // ERROR Type mismatch.


    lootBarrel.item = Coin(15)
    val myFedora: Fedora = fedoraBarrel.item
//    val myFedora2: Fedora = lootBarrel.item
}
