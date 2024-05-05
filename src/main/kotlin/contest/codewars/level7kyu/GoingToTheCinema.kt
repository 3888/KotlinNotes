package contest.codewars.level7kyu

import kotlin.math.ceil
import kotlin.math.pow

fun main() {

    movieMy(500, 15, 0.9)//  should return 43 (with card the total price is 634, with tickets 645)
//    movie(100, 10, 0.95) // should return 24  (with card the total price is 235, with tickets 240)
//    movie(0, 10, 0.95)
}


private fun movieMy(card: Int, ticket: Int, perc: Double): Int = when (card) {
    ticket -> 1
    0 -> 2
    else -> {
        var count = 0
        var cardProgram = card.toDouble()
        var cardProgramTicket = ticket.toDouble()

        while (ceil(cardProgram) >= ticket * count) {
            cardProgramTicket *= perc
            cardProgram += cardProgramTicket
            count++
        }
        count
    }
}

private fun movie(card: Int, ticket: Int, perc: Double) = generateSequence(1) { it + 1 }.first {
    ticket * it > ceil(card + ticket * perc * (1 - perc.pow(it)) / (1 - perc))
}