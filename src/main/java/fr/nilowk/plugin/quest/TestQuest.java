package fr.nilowk.plugin.quest;

import fr.nilowk.plugin.quest.utils.Quest;

import java.util.UUID;

public class TestQuest implements Quest {


    @Override
    public UUID getUuid() {
        return UUID.fromString("test");
    }

    @Override
    public String getName() {
        return "petit test";
    }

    @Override
    public String getDescription() {
        return null;
    }

}
