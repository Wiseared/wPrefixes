package xyz.wiseared.wprefixes.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bson.Document;
import org.bukkit.Bukkit;
import xyz.wiseared.wprefixes.utils.CC;
import xyz.wiseared.wprefixes.wPrefixes;

import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class MongoDB {

    private wPrefixes plugin;
    private MongoDatabase database;
    private MongoCollection<Document> playerdata;

    public MongoDB(wPrefixes plugin) {
        this.plugin = plugin;
        connect();
    }

    public void connect() {

        System.setProperty("DEBUG.GO", "true");
        System.setProperty("DB.TRACE", "true");
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.WARNING);

        MongoClient mongoClient = MongoClients.create(plugin.getConfig().getString("SETTINGS.MONGO.URL"));
        database = mongoClient.getDatabase(plugin.getConfig().getString("SETTINGS.MONGO.DATABASE"));
        loadCollections();

        Bukkit.getConsoleSender().sendMessage(CC.translate("&7[&6MongoDB&7] &fConnected to the &edatabase"));
        Bukkit.getConsoleSender().sendMessage(" ");
    }

    public void loadCollections() {
        playerdata = database.getCollection("playerdata");
    }
}