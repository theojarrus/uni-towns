import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TownsSourceTest {

    @Test
    fun getByFirstLetterCheckLetter() {
        // Given
        val testTownsApi = TestTownsApi("агород", "бгород")
        val townsSource = TownsSourceImpl(testTownsApi)
        val letter = 'б'
        val history = emptyList<String>()
        // Expected
        val expected = "бгород"
        // Actual
        val actual = townsSource.getByFirstLetter(letter, history)
        assertEquals(expected, actual)
    }

    @Test
    fun getByFirstLetterCheckCase() {
        // Given
        val testTownsApi = TestTownsApi("Агород", "агород")
        val townsSource = TownsSourceImpl(testTownsApi)
        val letter = 'а'
        val history = emptyList<String>()
        // Expected
        val expected = "Агород"
        // Actual
        val actual = townsSource.getByFirstLetter(letter, history)
        assertEquals(expected, actual)
    }

    @Test
    fun getByFirstLetterCheckHistory() {
        // Given
        val testTownsApi = TestTownsApi("агород")
        val townsSource = TownsSourceImpl(testTownsApi)
        val letter = 'а'
        val history = listOf("агород")
        // Expected
        val expected = null
        // Actual
        val actual = townsSource.getByFirstLetter(letter, history)
        assertEquals(expected, actual)
    }

    @Test
    fun containsCheckExist() {
        // Given
        val testTownsApi = TestTownsApi("агород")
        val townsSource = TownsSourceImpl(testTownsApi)
        val town = "агород"
        // Expected
        val expected = true
        // Actual
        val actual = townsSource.contains(town)
        assertEquals(expected, actual)
    }

    @Test
    fun containsCheckNotExist() {
        // Given
        val testTownsApi = TestTownsApi("агород")
        val townsSource = TownsSourceImpl(testTownsApi)
        val town = "бгород"
        // Expected
        val expected = false
        // Actual
        val actual = townsSource.contains(town)
        assertEquals(expected, actual)
    }
}
