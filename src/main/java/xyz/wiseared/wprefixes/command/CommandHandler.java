package xyz.wiseared.wprefixes.command;

import xyz.wiseared.wprefixes.command.commands.PrefixCommand;
import xyz.wiseared.wprefixes.command.commands.wPrefixCommand;
import xyz.wiseared.wprefixes.utils.command.Zetsu;
import xyz.wiseared.wprefixes.wPrefixes;

import java.util.Arrays;

public class CommandHandler {

    public CommandHandler(wPrefixes wPrefixes) {

        Zetsu zetsu = new Zetsu(wPrefixes);

        Arrays.asList(
                new wPrefixCommand(),
                new PrefixCommand()
        ).forEach(zetsu::registerCommands);
    }
}