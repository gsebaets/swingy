package com.view;

import com.controller.ArenaController;
import com.controller.*;
import com.model.PlayerModel;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ArenaConsoleView extends Player_View implements Display {



    private static int getKey(){
        String stringOption="";
        Scanner scan =  new Scanner(System.in);
        while (true)
        {
            System.out.print("Option: ");
            if (scan.hasNextLine())
                stringOption = scan.nextLine();
            else
                System.exit(0);
            if (stringOption.matches("^\\d$") && Integer.parseInt(stringOption) >= 1 && Integer.parseInt(stringOption)<=5)
                break;
        }
        return (Integer.parseInt(stringOption));
    }

    public static void printDetails(PlayerModel hero, int wholeMap){

        int option;

        System.out.println("Warrior :" + hero.getName());
        System.out.println("XP :" + hero.getExperience());
        System.out.println("Health :" + hero.getHitPoints());



        for (int y = 0; y < wholeMap; y++){
            for (int x = 0; x < wholeMap; x++)
            {
                if(ArenaController.arena[y][x] != '*')
                    System.out.print("[ " + ArenaController.arena[y][x] + " ]");
                else
                    System.out.print("[   ]");
            }
            System.out.println();

        }

            if(ArenaController.enemyEncountered(hero)) {
            fightOrFlight(ArenaController.getEnemy(hero));
        }
        else {

                if (hero.getX() == 0 || hero.getX() == wholeMap - 1) {
                    System.out.println("You Have Won the game");
                    databaseController.savePLayer(hero);
                    System.exit(1);
                }
                if (hero.getY() == 0 || hero.getY() == wholeMap - 1) {
                    databaseController.savePLayer(hero);
                    System.out.println("You Have Won the game");
                    System.exit(1);
                }
            System.out.println();
            System.out.println("  Navigation");
            System.out.println("==============");
            System.out.println("|| 1. North ||");
            System.out.println("|| 2. East  ||");
            System.out.println("|| 3. West  ||");
            System.out.println("|| 4. South ||");
            System.out.println("==============");
            System.out.println("|| 5. Close ||");
            System.out.println("==============");
            option = getKey();
            ArenaController.movement(option, hero);
        }
    }

    public static void fightOrFlight(PlayerModel enemy){

        int option;

            do {
                System.out.println("\nDo you choose to fight " + enemy.getName() +"?");
                System.out.println("==============");
                System.out.println("|| 1. Fight ||");
                System.out.println("|| 2. Run   ||");
                System.out.println("==============");
                option = getKey();
            } while (option < 1 && option > 2);
            if (option == 1) {
                ArenaController.fighting(enemy);
            }
            else
                ArenaController.goBack(ArenaController.playerModel, enemy);
    }


}