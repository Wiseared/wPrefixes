package xyz.wiseared.wprefixes.profile.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.wiseared.wprefixes.profile.Profile;
import xyz.wiseared.wprefixes.utils.Configuration;
import xyz.wiseared.wprefixes.utils.Message;
import xyz.wiseared.wprefixes.wPrefixes;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (!Configuration.CUSTOM_CHAT) return;
        Player player = event.getPlayer();
        Profile profile = wPrefixes.getInstance().getProfileManager().getProfile(player.getUniqueId());
        event.setCancelled(true);
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            if (profile.getPrefix().equalsIgnoreCase("none")) {
                Message.sendToAllPapi(Configuration.GLOBAL_CHAT.replace("%message%", event.getMessage()).replace("%player%", player.getName()));
            } else {
                Message.sendToAllPapi(Configuration.GLOBAL_CHAT_PREFIX.replace("%message%", event.getMessage()).replace("%prefix%", profile.getPrefix()).replace("%player%", player.getName()));
            }
        } else {
            if (profile.getPrefix().equalsIgnoreCase("none")) {
                Message.sendToAll(Configuration.GLOBAL_CHAT.replace("%message%", event.getMessage()).replace("%player%", player.getName()));
            } else {
                Message.sendToAll(Configuration.GLOBAL_CHAT_PREFIX.replace("%message%", event.getMessage()).replace("%prefix%", profile.getPrefix()).replace("%player%", player.getName()));
            }
        }
    }
}