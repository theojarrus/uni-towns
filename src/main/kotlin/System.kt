import kotlin.system.exitProcess

interface System {
    
    fun exit()
}

class SystemImpl : System {
    
    override fun exit() {
        exitProcess(0)
    }
}