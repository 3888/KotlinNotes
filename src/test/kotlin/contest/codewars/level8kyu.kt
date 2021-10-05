package contest.codewars

import contest.codewars.level8kyu.digitize
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class level8kyu {
    @Test
    fun `reverse number`() {
        assertArrayEquals(intArrayOf(1, 1, 1, 3, 2, 5, 3), digitize(3523111))
    }

    @Test
    fun `sum of all natural numbers that are multiples of 3 or 5`() {
        assertEquals(23, multiplesOf3Or5(10))
        assertEquals(78, multiplesOf3Or5(20))
        assertEquals(9168, multiplesOf3Or5(200))
    }
}