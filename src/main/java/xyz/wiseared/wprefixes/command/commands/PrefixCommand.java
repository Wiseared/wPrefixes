package xyz.wiseared.wprefixes.command.commands;

import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.entity.Player;
import xyz.wiseared.wprefixes.profile.Profile;
import xyz.wiseared.wprefixes.utils.CC;
import xyz.wiseared.wprefixes.utils.Configuration;
import xyz.wiseared.wprefixes.utils.Messages;
import xyz.wiseared.wprefixes.utils.command.permissible.impl.permissible.Permissible;
import xyz.wiseared.wprefixes.utils.command.schema.annotations.Command;
import xyz.wiseared.wprefixes.utils.command.schema.annotations.parameter.Param;
import xyz.wiseared.wprefixes.wPrefixes;

public class PrefixCommand {

    @Command(labels = {"prefix"}, description = "Change your prefix")
    @Permissible("wprefix.command")
    public void prefixCommand(Player player, @Param("prefix") String prefix) {
        Profile profile = wPrefixes.getInstance().getProfileManager().getProfile(player.getUniqueId());
        if (profile.getChangeCooldown() > System.currentTimeMillis()) {
            long time = profile.getChangeCooldown() - System.currentTimeMillis();
            player.sendMessage(CC.translate(Messages.COOLDOWN.replace("%time%", DurationFormatUtils.formatDurationWords(time, true, true)).replace("%prefix%", Configuration.PREFIX)));
            return;
        }
        long time =  System.currentTimeMillis() + Configuration.COOLDOWN;
        profile.setChangeCooldown(time);
        profile.setPrefix(prefix);
        player.sendMessage(CC.translate(Messages.PREFIX_CHANGED.replace("%new%", prefix).replace("%prefix%", Configuration.PREFIX)));
    }
}