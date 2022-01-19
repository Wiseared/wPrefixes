package xyz.wiseared.wprefixes.profile.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import xyz.wiseared.wprefixes.profile.Profile;
import xyz.wiseared.wprefixes.wPrefixes;

import java.io.IOException;

public class JoinListener implements Listener {

    @EventHandler
    public final void onAsyncPreLogin(AsyncPlayerPreLoginEvent event) throws IOException {
        Profile profile;
        profile = new Profile(event.getUniqueId(), event.getName());
        wPrefixes.getInstance().getProfileManager().addProfile(profile);
        if (profile.getPrefix() == null) {
            profile.setPrefix("None");
        }
        profile.save();
    }
}