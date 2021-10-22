package bignerdranch.sandbox

// class LootBox<T : Loot>(item: T) {
class LootBox<T : Loot>(vararg item: T) {
    var open = true
    private var loot: Array<out T> = item

    operator fun get(index: Int): T? = loot[index].takeIf { open }

    fun fetch(item: Int): T? {
        return loot[item].takeIf { open }
    }

    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }

    //    fun fetch(): T? {
//        return loot.takeIf { open }
//    }

    /*
    R, сокращенно от "return" (возврат), потому что он определяет тип возвращаемого значения
    **/
//    fun <R> fetch(lootModFunction: (T) -> R): R? {
//        return lootModFunction(loot).takeIf { open }
//    }

}

