fun main() {
    val system = SystemImpl()
    val terminal = TerminalImpl()
    val api = TownsSourceImpl(TownsDatabase)
    val game = TownsGame(system, terminal, api)
    game.run()
}
