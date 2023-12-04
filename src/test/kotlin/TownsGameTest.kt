import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

private const val TEXT_ERROR_NOT_EXIST = "Ошибка: такого города нет"
private const val TEXT_WIN = "Результат: победа"
private const val TEXT_LOSE = "Результат: поражение"
private const val TEXT_RULES = "Игра в города России.\n" +
        "Называйте названия городов по очереди, каждое следующее название должно начинаться с буквы предыдущего\n" +
        "Для старта напишите название города, для завершения - пустую строку"

class TownsGameTest {

    @Test
    fun runCheck() {
        // Given
        val testSystem = TestSystem()
        val testTerminal = TestTerminal()
        val testTownsSource = TestTownsSource(null, false)
        val game = TownsGame(testSystem, testTerminal, testTownsSource)
        // Expected
        val expected = listOf(TEXT_RULES)
        val expectedExit = false
        // Actual
        game.run()
        val actual = testTerminal.output
        val actualExit = testSystem.isExitCalled
        assertEquals(expected, actual)
        assertEquals(expectedExit, actualExit)
    }

    @Test
    fun readLinesCheckEmpty() {
        // Given
        val testSystem = TestSystem()
        val testTerminal = TestTerminal("")
        val testTownsSource = TestTownsSource(null, false)
        val game = TownsGame(testSystem, testTerminal, testTownsSource)
        // Expected
        val expected = listOf(TEXT_LOSE)
        val expectedExit = true
        // Actual
        game.readLines()
        val actual = testTerminal.output
        val actualExit = testSystem.isExitCalled
        assertEquals(expected, actual)
        assertEquals(expectedExit, actualExit)
    }

    @Test
    fun readLinesCheckNotExist() {
        // Given
        val testSystem = TestSystem()
        val testTerminal = TestTerminal("Аыаывав")
        val testTownsSource = TestTownsSource(null, false)
        val game = TownsGame(testSystem, testTerminal, testTownsSource)
        // Expected
        val expected = listOf(TEXT_ERROR_NOT_EXIST)
        val expectedExit = false
        // Actual
        game.readLines()
        val actual = testTerminal.output
        val actualExit = testSystem.isExitCalled
        assertEquals(expected, actual)
        assertEquals(expectedExit, actualExit)
    }

    @Test
    fun readLinesCheckTryFindNextTownNotFound() {
        // Given
        val testSystem = TestSystem()
        val testTerminal = TestTerminal("Агород")
        val testTownsSource = TestTownsSource(null, true)
        val game = TownsGame(testSystem, testTerminal, testTownsSource)
        // Expected
        val expected = listOf(TEXT_WIN)
        val expectedExit = true
        // Actual
        game.readLines()
        val actual = testTerminal.output
        val actualExit = testSystem.isExitCalled
        assertEquals(expected, actual)
        assertEquals(expectedExit, actualExit)
    }

    @Test
    fun readLinesCheckTryFindNextTownFound() {
        // Given
        val nextTown = "Дгород"
        val testSystem = TestSystem()
        val testTerminal = TestTerminal("Агород")
        val testTownsSource = TestTownsSource(nextTown, true)
        val game = TownsGame(testSystem, testTerminal, testTownsSource)
        // Expected
        val expected = listOf(nextTown)
        val expectedExit = false
        // Actual
        game.readLines()
        val actual = testTerminal.output
        val actualExit = testSystem.isExitCalled
        assertEquals(expected, actual)
        assertEquals(expectedExit, actualExit)
    }
}
