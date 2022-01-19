package xyz.wiseared.wprefixes.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import xyz.wiseared.wprefixes.wPrefixes;

public class Messages {

    public static String NO_PERMISSION;

    public static String PREFIX_CHANGED;

    public static String COOLDOWN;
    public static String COOLDOWN_REMOVED;

    public static void init() {
        YamlConfiguration messages = wPrefixes.getInstance().getMessagesYML().getConfig();

        NO_PERMISSION = messages.getString("MESSAGES.NO-PERMISSION");

        PREFIX_CHANGED = messages.getString("MESSAGES.PREFIX-CHANGED");

        COOLDOWN = messages.getString("MESSAGES.COOLDOWN");
        COOLDOWN_REMOVED = messages.getString("MESSAGES.RESET");
    }
}