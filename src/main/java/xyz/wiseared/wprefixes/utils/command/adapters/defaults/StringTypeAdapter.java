package xyz.wiseared.wprefixes.utils.command.adapters.defaults;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.wiseared.wprefixes.utils.command.adapters.ParameterAdapter;

public class StringTypeAdapter implements ParameterAdapter<String> {

    @Override
    public String process(@NotNull String str) {
        return str;
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        //Never
    }
}
