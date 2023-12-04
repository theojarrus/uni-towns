interface Terminal {

    fun print(message: String)

    fun read(): String?
}

class TerminalImpl : Terminal {

    override fun print(message: String) {
        println(message)
    }

    override fun read(): String {
        return readln()
    }
}
