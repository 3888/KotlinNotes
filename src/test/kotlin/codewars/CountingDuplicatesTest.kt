import codewars.duplicateCountSolutionsExample
import org.junit.Test
import kotlin.test.assertEquals

class CountingDuplicatesTest {

    @Test
    fun `abcde returns zero`() {
        assertEquals(0, duplicateCountSolutionsExample("abcde"))
    }

    @Test
    fun `abcdea returns one`() {
        assertEquals(1, duplicateCountSolutionsExample("abcdea"))
    }

    @Test
    fun `indivisibility returns one`() {
        assertEquals(1, duplicateCountSolutionsExample("indivisibility"))
    }

    @Test
    fun `really long string containing duplicates returns three`() {
        val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
        assertEquals(3, duplicateCountSolutionsExample(text))
    }
}