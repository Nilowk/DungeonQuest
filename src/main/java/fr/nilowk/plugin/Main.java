package fr.nilowk.plugin;

import fr.nilowk.plugin.db.Profile;
import fr.nilowk.plugin.db.ProfileSerializationManager;
import fr.nilowk.plugin.listeners.PlayerJoin;
import fr.nilowk.plugin.quest.utils.Quest;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.util.*;
import java.sql.Date;

public class Main extends JavaPlugin {

    private ProfileSerializationManager profileSerializationManager;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        this.profileSerializationManager = new ProfileSerializationManager();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);

    }

    public ProfileSerializationManager getProfileSerializationManager() {

        return profileSerializationManager;

    }

    public void loadScoreBoard(Profile profile) {

        Player player = getServer().getPlayer(profile.getUuid());
        float money = profile.getMoney();
        String grade = profile.getGrade();
        int level = profile.getLevel();

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective title = scoreboard.registerNewObjective(getConfig().getString("scoreboard.title"), "dummy", getConfig().getString("scoreboard.title"));

        title.setDisplaySlot(DisplaySlot.SIDEBAR);

      /*  if (quests.size() > 0) {

            Score date = title.getScore("§7" + new Date(System.currentTimeMillis()).toString().replace("-", "/"));
            date.setScore(11);

            Score space = title.getScore(" ");
            space.setScore(10);

            Score rank = title.getScore("Rank: " + grade);
            rank.setScore(9);
            Score lvl = title.getScore("level: §9" + level);
            lvl.setScore(8);

            Score space1 = title.getScore("  ");
            space1.setScore(7);

            Score cash = title.getScore("Golds: §6" + money);
            cash.setScore(6);

            Score space2 = title.getScore("   ");
            space2.setScore(5);

            Score objectives = title.getScore("§eRecent Objective:");
            objectives.setScore(4);
            Score objective = title.getScore("- " + quests.get(quests.size() - 1).getName());
            objective.setScore(3);

            Score space3 = title.getScore("    ");
            space3.setScore(2);

            Score site = title.getScore("§5" + getConfig().getString("scoreboard.site"));
            site.setScore(1);

        } else {*/

        Score date = title.getScore("§7" + new Date(System.currentTimeMillis()).toString().replace("-", "/"));
        date.setScore(11);

        Score space = title.getScore(" ");
        space.setScore(10);

        Score rank = title.getScore("Rank: " + grade);
        rank.setScore(9);
        Score lvl = title.getScore("level: §9" + level);
        lvl.setScore(8);

        Score space1 = title.getScore("  ");
        space1.setScore(7);

        Score cash = title.getScore("Golds: §6" + money);
        cash.setScore(6);

        Score space2 = title.getScore("   ");
        space2.setScore(5);

        Score objectives = title.getScore("§eObjectives:");
        objectives.setScore(4);
        Score objective = title.getScore("- No Quest");
        objective.setScore(3);

        Score space3 = title.getScore("    ");
        space3.setScore(2);

        Score site = title.getScore("§5" + getConfig().getString("scoreboard.site"));
        site.setScore(1);

     //   }

        player.setScoreboard(scoreboard);

    }

}
