package main.java.com.model;

public class PlayerModel {

    private String name;
    private String ClassP;
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hitPoints;


    public PlayerModel(String name, String ClassP, int level, int Experience, int Attack,
                       int defence, int hitPoints) {
        this.name = name;
        this.ClassP = ClassP;
        this.level = level;
        this.experience = Experience;
        this.attack = Attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getClassP() {
        return ClassP;
    }
    public void setClassP(String classP) {
        ClassP = classP;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

}

