package main.java.com.view;

import main.java.com.controller.ArenaController;
import main.java.com.controller.PlayerController;
import main.java.com.model.PlayerModel;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Scanner;

public abstract class ArenaConsoleView extends Player_View implements Display {

    private ArenaController arenaController;
    private PlayerModel playerModel;
    private char map[][];

    private int getKey(){
        String stringOption;
        int option;
        Scanner scan =  new Scanner(System.in);

        try{
            stringOption = scan.nextLine();
            option = Integer.parseInt(stringOption);
            return (getKey());
        }
        catch (Exception error){
            System.out.println("Invalid Option");
            return (getKey());
        }
    }

    private void printMap(){
        int width;
        int height;
        int option;
        boolean keyPressed;

        width = this.map[0].length;
        height = this.map.length;

        System.out.print("Warrior :" + this.playerModel.getName());
        System.out.print("XP :" + this.playerModel.getExperience());
        System.out.print("Health :" + this.playerModel.getHitPoints());

        for (int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                System.out.print(map[y][x]);
            }
            System.out.println();
        }

        do{
            System.out.println("Navigation");
            System.out.println("==============");
            System.out.println("|| 1. North ||");
            System.out.println("|| 2. East  ||");
            System.out.println("|| 3. West  ||");
            System.out.println("|| 4. South ||");
            System.out.println("==============");
            System.out.println("|| 5. Close ||");
            System.out.println("==============");
            System.out.print("Option : ");
            option = this.getKey();
            keyPressed = (option >= 0 && option <= 4);
        }while(!keyPressed);
        this.arenaController.movement(option);
    }
}