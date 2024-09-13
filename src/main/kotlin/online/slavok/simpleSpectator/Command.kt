package online.slavok.simpleSpectator

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Command : CommandExecutor {
    private val positions = mutableMapOf<Player, Location>()
    override fun onCommand(sender: CommandSender, command: Command, label: String, agrs: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Команду может использовать только игрок")
            return true
        }
        if (positions.contains(sender)) {
            sender.teleport(positions[sender]!!)
            sender.gameMode = GameMode.SURVIVAL
            positions.remove(sender)
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Felarmonia</gray> <white><bold>></bold></white> <blue>Вы вышли из режима наблюдателя.</blue>"))
            return true
        } else {
            positions[sender] = sender.location
            sender.gameMode = GameMode.SPECTATOR
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<gray>Felarmonia</gray> <white><bold>></bold></white> <aqua>Вы вошли в режим наблюдателя.</aqua>"))
            return true
        }
    }
}