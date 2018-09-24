package com.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PlayerModel {

    @NotNull (message = "Name can't be empty")
    @Length(min = 4, max = 15, message = "Length between 5 -15 and not empty")
    private String name;
    @NotNull(message = "Class can't be blank")
    private String ClassP;
    @NotNull
    @Max(value = 30, message = "Level cannot pass 2")
    @Min(value = 1, message = "Level cannot be bellow 1")
    private int level;
    @NotNull
    @Min(value = 1000, message = "XP cannot be lower than 1000")
    private int experience;
    @NotNull
    @Max(value = 100, message = "Attack Maximum is 100")
    @Min(value = 5, message = "Minimum attack is 5")
    private int attack;
    @NotNull
    @Max(value = 75, message = "Defence max is 75")
    @Min(value = 0, message = "Cannot be lower that 0")
    private int defence;
    @NotNull
    @Max(value = 100, message = "Max Health is 100")
    @Min(value = 0, message =  "Min health 0")
    private int hitPoints;
    private int x;
    private int y;


    public  PlayerModel(String name, String ClassP)
    {
        this.name = name;
        this.ClassP = ClassP;
    }
    public PlayerModel(String name, String ClassP, int level, int Experience, int Attack,
                       int defence, int hitPoints) {
        this.name = name;
        this.ClassP = ClassP;
        this.level = level;
        this.experience = Experience;
        this.attack = Attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.x = 0;
        this.y = 0;
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

    public int getLevel() { return level; }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() { return experience;}
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

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public void	setPosition(int y, int x) { this.y = y; this.x = x; }
}

