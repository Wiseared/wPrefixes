package xyz.wiseared.wprefixes;

import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.wiseared.wprefixes.command.CommandHandler;
import xyz.wiseared.wprefixes.database.MongoDB;
import xyz.wiseared.wprefixes.profile.managers.ProfileManager;
import xyz.wiseared.wprefixes.utils.CC;
import xyz.wiseared.wprefixes.utils.Configuration;
import xyz.wiseared.wprefixes.utils.Messages;
import xyz.wiseared.wprefixes.utils.YamlDoc;

import java.io.IOException;

@Getter
public class wPrefixes extends JavaPlugin {

    private static wPrefixes instance;
    private String prefix;
    private MongoDB mongoDB;
    private CommandHandler commandHandler;
    private ProfileManager profileManager;
    private YamlDoc messagesYML, dataYML;

    public static wPrefixes getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        this.saveDefaultConfig();
    }

    @SneakyThrows
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7&m-------------------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(" ");
        registerConfigs();
        Messages.init();
        Configuration.init();
        this.prefix = getConfig().getString("SETTINGS.PREFIX");
        registerManagers();
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(CC.translate("&fEnabled &4&lwPrefixes"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&fMade by &cWiseared"));
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7&m-------------------------------------------------"));
    }

    private void registerConfigs() throws IOException {
        Bukkit.getConsoleSender().sendMessage(CC.translate("&fLoaded &cconfig.yml"));
        messagesYML = new YamlDoc(getDataFolder(), "messages.yml");
        messagesYML.init();
        Bukkit.getConsoleSender().sendMessage(CC.translate("&fLoaded &cmessages.yml"));
        dataYML = new YamlDoc(getDataFolder(), "data.yml");
        dataYML.init();
        Bukkit.getConsoleSender().sendMessage(CC.translate("&fLoaded &cdata.yml"));
    }

    private void registerManagers() {
        commandHandler = new CommandHandler(this);
        if (Configuration.DATA_TYPE.equalsIgnoreCase("mongodb")) {
            mongoDB = new MongoDB(this);
        }
        profileManager = new ProfileManager();
    }
}