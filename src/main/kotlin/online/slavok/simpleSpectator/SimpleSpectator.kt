package online.slavok.simpleSpectator

import org.bukkit.plugin.java.JavaPlugin

class SimpleSpectator : JavaPlugin() {

    override fun onEnable() {
        getCommand("spectator")?.setExecutor(Command())
        getCommand("s")?.setExecutor(Command())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
