package fr.nilowk.plugin.db;

import java.util.UUID;

public class Profile {

    private UUID uuid;
    private String name;
    private float money;
    private String grade;
    private int level;
    private float levelStatus;

    public Profile(UUID uuid, String name, float money, String grade, int level, float levelStatus) {

        this.uuid = uuid;
        this.name = name;
        this.money = money;
        this.grade = grade;
        this.level = level;
        this.levelStatus = levelStatus;

    }

    public UUID getUuid() {

        return uuid;

    }

    public String getName() {

        return name;

    }

    public float getMoney() {

        return money;

    }

    public String getGrade() {

        return grade;

    }

    public int getLevel() {

        return level;

    }

    public float getLevelStatus() {

        return levelStatus;

    }

    public void setUuid(UUID uuid) {

        this.uuid = uuid;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void setMoney(float money) {

        this.money = money;

    }

    public void setGrade(String grade) {

        this.grade = grade;

    }

    public void setLevel(int level) {

        this.level = level;

    }

    public void setLevelStatus(float levelStatus) {

        this.levelStatus = levelStatus;

    }

}
