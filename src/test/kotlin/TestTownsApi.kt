class TestTownsApi(vararg towns: String) : TownsApi{

    override val list: List<String> = towns.toList()
}
