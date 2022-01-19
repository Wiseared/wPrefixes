package xyz.wiseared.wprefixes.profile;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import xyz.wiseared.wprefixes.utils.Configuration;
import xyz.wiseared.wprefixes.wPrefixes;

import java.io.IOException;
import java.util.UUID;

@Getter
@Setter
public class Profile {

    private UUID uuid;
    private String name, prefix;
    private long changeCooldown;

    public Profile(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        load();
    }

    public void load() {
        if (Configuration.DATA_TYPE.equalsIgnoreCase("mongodb")) {
            Document document = wPrefixes.getInstance().getMongoDB().getPlayerdata().find(Filters.eq("uuid", getUuid().toString())).first();
            if (document != null) {
                this.prefix = document.getString("prefix");
                this.changeCooldown = document.getLong("changeCooldown");
            }
        } else {
            this.changeCooldown = wPrefixes.getInstance().getDataYML().getConfig().getLong("PLAYER-DATA." + uuid + ".COOLDOWN");
            this.prefix = wPrefixes.getInstance().getDataYML().getConfig().getString("PLAYER-DATA." + uuid + ".PREFIX");
        }
    }

    public void save() throws IOException {
        if (Configuration.DATA_TYPE.equalsIgnoreCase("mongodb")) {
            Document document = new Document();
            document.put("name", getName().toLowerCase());
            document.put("capsName", getName());
            document.put("uuid", getUuid().toString());
            document.put("prefix", getPrefix());
            document.put("changeCooldown", getChangeCooldown());
            wPrefixes.getInstance().getMongoDB().getPlayerdata().replaceOne(Filters.eq("uuid", getUuid().toString()), document, new UpdateOptions().upsert(true));
        } else {
            wPrefixes.getInstance().getDataYML().getConfig().set("PLAYER-DATA." + uuid + ".COOLDOWN", changeCooldown);
            wPrefixes.getInstance().getDataYML().getConfig().set("PLAYER-DATA." + uuid + ".PREFIX", prefix);
            wPrefixes.getInstance().getDataYML().save();
        }
    }
}