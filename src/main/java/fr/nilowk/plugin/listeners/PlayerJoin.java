package fr.nilowk.plugin.listeners;

import fr.nilowk.plugin.Main;
import fr.nilowk.plugin.db.FileUtils;
import fr.nilowk.plugin.db.Profile;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class PlayerJoin implements Listener {

    private Main instance;
    private FileConfiguration config;
    private File saveDir;

    public PlayerJoin(Main instance) {

        this.instance = instance;
        this.config = instance.getConfig();
        this.saveDir = new File(instance.getDataFolder(), "/profiles/");

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        File file = new File(saveDir, player.getUniqueId() + ".json");
        if (!file.exists()) onFirstJoin(event);
        Profile profile = instance.getProfileSerializationManager().deserialize(FileUtils.loadContent(file));

        if (!profile.getName().equalsIgnoreCase(player.getName())) {

            profile.setName(player.getName());
            FileUtils.save(file, instance.getProfileSerializationManager().serialize(profile));

        }

        instance.loadScoreBoard(profile);
        player.setLevel(profile.getLevel());

    }

    public void onFirstJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        File file = new File(saveDir, player.getUniqueId() + ".json");

        try {
            FileUtils.createFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Profile profile = new Profile(player.getUniqueId(), player.getName(), (float) config.getDouble("default.money"), config.getString("default.grade"), 1, 0.0f);

        String json = instance.getProfileSerializationManager().serialize(profile);
        FileUtils.save(file, json);

        instance.loadScoreBoard(profile);
        player.setLevel(0);

    }

}
