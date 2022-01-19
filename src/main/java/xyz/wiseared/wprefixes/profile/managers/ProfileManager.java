package xyz.wiseared.wprefixes.profile.managers;

import lombok.Getter;
import org.bukkit.Bukkit;
import xyz.wiseared.wprefixes.profile.Profile;
import xyz.wiseared.wprefixes.profile.listeners.ChatListener;
import xyz.wiseared.wprefixes.profile.listeners.JoinListener;
import xyz.wiseared.wprefixes.wPrefixes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class ProfileManager {

    private final Set<Profile> profiles;

    public ProfileManager() {
        Bukkit.getPluginManager().registerEvents(new ChatListener(), wPrefixes.getInstance());
        Bukkit.getPluginManager().registerEvents(new JoinListener(), wPrefixes.getInstance());
        profiles = new HashSet<>();
    }

    public final void addProfile(Profile profile) {
        profiles.add(profile);
        profile.load();
    }

    public final void removeProfile(Profile profile) {
        profiles.remove(profile);
    }

    public final Profile getProfile(UUID uuid) {
        return profiles.stream().filter(profile -> profile.getUuid() == uuid).findFirst().orElse(null);
    }

    public final Set<Profile> getProfiles() {
        return this.profiles;
    }
}