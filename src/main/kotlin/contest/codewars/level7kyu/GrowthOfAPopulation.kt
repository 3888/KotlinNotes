package contest.codewars.level7kyu

fun main() {
    //    nbYear(1000.0, 2.0, 50, 1200)// 3
//    nbYear(1500.0, 5.0, 100, 5000)// 15
    println(nbYear(1500000, 2.5, 10000, 2000000))// 10
}

fun nbYearMy(startPopulation: Int, increasePercent: Double, newInhabitants: Int, finalPopulation: Int): Int {
    var result = 0.0
    var newPopulation = startPopulation
    var count = 0
    while (result < finalPopulation) {
        result = newPopulation * (1 + increasePercent / 100) + newInhabitants
        newPopulation = result.toInt()
        count += 1

    }
    return count
}

fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int =
    generateSequence(pp0.toDouble()) { it * (1 + percent / 100) + aug }.takeWhile { it < p }.count()

fun nbYear2(pp0: Int, percent: Double, aug: Int, p: Int): Int {
    var currentPeople = (pp0).toDouble()
    var years = 0

    while (p > currentPeople) {
        currentPeople += currentPeople * (percent / 100) + aug
        years++
    }
    return years
}