package xyz.wiseared.wprefixes.utils.command.adapters.defaults;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.wiseared.wprefixes.utils.command.adapters.ParameterAdapter;

public class IntegerTypeAdapter implements ParameterAdapter<Integer> {

    @Override
    public Integer process(@NotNull String str) {
        return Integer.valueOf(str);
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        sender.sendMessage(ChatColor.RED + "'" + given + "' is not a valid number.");
    }
}
