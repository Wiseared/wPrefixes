package xyz.wiseared.wprefixes.command.commands;

import org.bukkit.entity.Player;
import xyz.wiseared.wprefixes.profile.Profile;
import xyz.wiseared.wprefixes.utils.CC;
import xyz.wiseared.wprefixes.utils.Configuration;
import xyz.wiseared.wprefixes.utils.Messages;
import xyz.wiseared.wprefixes.utils.command.permissible.impl.permissible.Permissible;
import xyz.wiseared.wprefixes.utils.command.schema.annotations.Command;
import xyz.wiseared.wprefixes.utils.command.schema.annotations.parameter.Param;
import xyz.wiseared.wprefixes.wPrefixes;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class wPrefixCommand {

    private final List<String> helpMessage = Arrays.asList(
            "&7&m------------------------------",
            "&fThis server is using &4&lwPrefix",
            "&fMade by &cWiseared",
            "&7&m------------------------------"
    );

    @Command(labels = {"wprefix"}, description = "wPrefix Command")
    @Permissible("wprefix.main")
    public void wprefixCommand(Player player) {
        helpMessage.forEach(s -> player.sendMessage(CC.translate(s)));
    }

    @Command(labels = {"wprefix reset"}, description = "wPrefix Reset Command")
    @Permissible("wprefix.reset")
    public void wprefixResetCommand(Player player, @Param("target") Player target) {
        Profile profile = wPrefixes.getInstance().getProfileManager().getProfile(target.getUniqueId());
        profile.setChangeCooldown(0);
        player.sendMessage(CC.translate(Messages.COOLDOWN_REMOVED.replace("prefix", Configuration.PREFIX).replace("%player%", target.getName())));
    }

    @Command(labels = {"wprefix reload"}, description = "wPrefix Reload Command")
    @Permissible("wprefix.reload")
    public void wprefixReloadCommand(Player player) throws IOException {
        wPrefixes.getInstance().getMessagesYML().reloadConfig();
        wPrefixes.getInstance().reloadConfig();
        wPrefixes.getInstance().saveConfig();
        Configuration.init();
        Messages.init();
        player.sendMessage(CC.translate("&aYou have reloaded all configs."));
    }
}