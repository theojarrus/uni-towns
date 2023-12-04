class TownsGame(
    private val system: System,
    private val terminal: Terminal,
    private val townsSource: TownsSource
) {

    private val history = mutableListOf<String>()

    fun run() {
        printRules()
        readLines()
    }

    fun stop(message: String) {
        terminal.print(message)
        system.exit()
    }

    fun printRules() {
        terminal.print("Игра в города России.\nНазывайте названия городов по очереди, каждое следующее название должно начинаться с буквы предыдущего\nДля старта напишите название города, для завершения - пустую строку")
    }

    fun printWrong() {
        terminal.print("Ошибка: город должен начинаться с последней буквы предыдущего")
    }

    fun printNotExist() {
        terminal.print("Ошибка: такого города нет")
    }

    fun readLines() {
        while (true) {
            val town = terminal.read() ?: break
            when {
                town.isEmpty() -> stop("Результат: поражение")
                history.lastOrNull()?.last()?.lowercaseChar()?.let { it != town.first().lowercaseChar() } ?: false -> printWrong()
                !townsSource.contains(town) -> printNotExist()
                else -> tryFindNextTown(town)
            }
        }
    }

    fun tryFindNextTown(previous: String): String {
        updateHistory(previous)
        val next = townsSource.getByFirstLetter(previous.last(), history)
        if (next == null) stop("Результат: победа")
        updateHistory(next.orEmpty())
        next?.let(terminal::print)
        return next.orEmpty()
    }

    fun updateHistory(town: String) {
        history.add(town)
    }
}
