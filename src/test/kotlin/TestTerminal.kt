class TestTerminal(private vararg val inputs: String) : Terminal {

    val output = mutableListOf<String>()
    var current = 0

    override fun print(message: String) {
        output.add(message)
    }

    override fun read(): String? {
        return inputs.getOrNull(current)?.also { current = current.inc() }
    }
}
