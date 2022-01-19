package xyz.wiseared.wprefixes.utils;

import org.bukkit.configuration.file.FileConfiguration;
import xyz.wiseared.wprefixes.wPrefixes;

public class Configuration {

    public static Boolean CUSTOM_CHAT;

    public static String DATA_TYPE;

    public static String GLOBAL_CHAT;
    public static String GLOBAL_CHAT_PREFIX;

    public static String PREFIX;

    public static Long COOLDOWN;

    public static void init() {
        FileConfiguration config = wPrefixes.getInstance().getConfig();

        CUSTOM_CHAT = config.getBoolean("SETTINGS.CUSTOM-CHAT");

        DATA_TYPE = config.getString("SETTINGS.DATA-TYPE");

        GLOBAL_CHAT = config.getString("SETTINGS.CHAT-FORMAT.GLOBAL");
        GLOBAL_CHAT_PREFIX = config.getString("SETTINGS.CHAT-FORMAT.GLOBAL-PREFIX");

        PREFIX = config.getString("SETTINGS.PREFIX");

        COOLDOWN = config.getLong("SETTINGS.PREFIX-COOLDOWN");
    }
}