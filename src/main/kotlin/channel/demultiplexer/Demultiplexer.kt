package channel.demultiplexer

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel

typealias Predicate<E> = (E) -> Boolean
typealias Rule<E> = Pair<Channel<E>, Predicate<E>>


class Demultiplexer<E>(vararg val rules: Rule<E>) {
    suspend fun consume(recv: ReceiveChannel<E>) {

        for (item in recv) {
// 1
//            for (rule in rules) {
//// 2
//                if (rule.second(item)) {
//// 3
//                    rule.first.send(item)

            /*
                   or via destructive declaration
                   https://kotlinlang.org/docs/destructuring-declarations.html
            */
            for ((channel, predicate) in rules) {
// 2
                if (predicate(item)) {
// 3
                    channel.send(item)

                }
            }
        }
// 4
        closeAll()
    }

    // Closes all the demultiplexed channels
    private fun closeAll() {
        rules.forEach { it.first.close() }
    }
}