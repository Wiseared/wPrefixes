package xyz.wiseared.wprefixes.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

@UtilityClass
public class Message {

    public void sendToAll(String message) {
        Bukkit.getServer().getOnlinePlayers().forEach(player -> player.sendMessage(CC.translate(message)));
    }
}