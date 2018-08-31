package main.java.com.controller;

import main.java.com.model.PlayerModel;
import java.util.Random;

public class ArenaController {

    private PlayerModel playerModel;
    private PlayerModel	enemyModel;
    private int[][] arena;
    int width;
    int height;

    public ArenaController() {

    }

    private String	getRank() {
        Random Fighter = new Random();
        String Rank[] = {"Hokage", "Anbu", "Jonin"};
        return (Rank[Fighter.nextInt(3)]);
    }

    private String  RandomEnemy() {
        Random Akatsuki = new Random();
        String names[] = {"Deidara", "Itachi", "Nagato", "Tobi", "Hidan"};
        return (names[Akatsuki.nextInt(5)]);
    }

    private void setStats(PlayerModel tempHero){
            Random rand = new Random();

        tempHero.setLevel(rand.nextInt(playerModel.getLevel() + 2) + 1);
        tempHero.setHitPoints(100);
            switch (tempHero.getClassP()) {
                case "Hokage":
                    tempHero.setExperience(300);
                    tempHero.setAttack(25);
                    tempHero.setDefence(25);

                    break ;
                case "Anbu":
                    tempHero.setExperience(250);
                    tempHero.setAttack(15);
                    tempHero.setDefence(10);

                    break ;
                case "Jonin":
                    tempHero.setExperience(150);
                    tempHero.setAttack(5);
                    tempHero.setDefence(5);

                    break ;
            }
        tempHero.setExperience(tempHero.getExperience() * tempHero.getLevel());
        tempHero.setAttack(tempHero.getAttack() * tempHero.getLevel());
        tempHero.setDefence(tempHero.getDefence() * (tempHero.getLevel() / 2));
        }

   public void fighting()
   {

   }
}
