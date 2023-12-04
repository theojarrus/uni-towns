interface TownsSource  {

    fun getByFirstLetter(letter: Char, history: List<String>): String?

    fun contains(town: String): Boolean
}

class TownsSourceImpl(private val townsApi: TownsApi) : TownsSource {

    override fun getByFirstLetter(letter: Char, history: List<String>): String? {
        return townsApi.list.firstOrNull { town ->
            town.first().lowercaseChar() == letter.lowercaseChar() && town !in history
        }
    }

    override fun contains(town: String): Boolean {
        return town in townsApi.list
    }
}
