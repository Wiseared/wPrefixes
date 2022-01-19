package xyz.wiseared.wprefixes.utils.command.permissible.impl.permissible;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.wiseared.wprefixes.utils.CC;
import xyz.wiseared.wprefixes.utils.Messages;
import xyz.wiseared.wprefixes.utils.command.permissible.PermissibleAttachment;

public class BukkitPermissionAttachment implements PermissibleAttachment<Permissible> {

    @Override
    public boolean test(Permissible annotation, @NotNull CommandSender sender) {
        return sender.hasPermission(annotation.value());
    }

    @Override
    public void onFail(@NotNull CommandSender sender, Permissible annotation) {
        sender.sendMessage(CC.translate(Messages.NO_PERMISSION));
    }
}
