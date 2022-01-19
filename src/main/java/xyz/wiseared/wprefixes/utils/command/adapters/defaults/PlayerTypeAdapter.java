package xyz.wiseared.wprefixes.utils.command.adapters.defaults;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.wiseared.wprefixes.utils.command.adapters.ParameterAdapter;

public class PlayerTypeAdapter implements ParameterAdapter<Player> {

    @Override
    public Player process(@NotNull String str) {
        return Bukkit.getPlayer(str);
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        sender.sendMessage(ChatColor.RED + "'" + given + "' is not online.");
    }
}
