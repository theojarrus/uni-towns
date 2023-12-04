class TestTownsSource(private val town: String?, private val contains: Boolean) : TownsSource {

    override fun getByFirstLetter(letter: Char, history: List<String>): String? {
        return town
    }

    override fun contains(town: String): Boolean {
        return contains
    }
}
