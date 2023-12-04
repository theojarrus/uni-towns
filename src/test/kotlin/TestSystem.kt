class TestSystem : System {

    var isExitCalled: Boolean = false

    override fun exit() {
        isExitCalled = true
    }
}
