package xyz.wiseared.wprefixes.utils.command.processor.bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.wiseared.wprefixes.utils.command.processor.impl.SpigotProcessor;
import xyz.wiseared.wprefixes.utils.command.tabcomplete.TabCompleteHandler;

import java.util.List;

public class BukkitCommand extends Command {

    private final @NotNull SpigotProcessor processor;
    private final @NotNull TabCompleteHandler handler;

    public BukkitCommand(String name, @NotNull SpigotProcessor processor, @NotNull TabCompleteHandler handler) {
        super(name);
        this.processor = processor;
        this.handler = handler;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        return processor.onCommand(commandSender, this, s, strings);
    }

    @Override
    @Nullable
    public List<String> tabComplete(@NotNull CommandSender sender,
                                    @NotNull String alias,
                                    @NotNull String[] args) throws IllegalArgumentException {
        //It's easier to separate chunks of code into different classes.
        return handler.getListener().onTabComplete(sender, this, alias, args);
    }
}
