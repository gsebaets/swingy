package main.java.com.view;

import main.java.com.controller.PlayerController;
import main.java.com.model.PlayerModel;

import java.util.Scanner;

public abstract class PlayerConsoleView extends Player_View implements Display {

    private PlayerController    playerController;
    private PlayerModel         playerModel;
    private Scanner             scanner;

    public PlayerConsoleView(){
        scanner = new Scanner(System.in);
    }

    private String  getPlayerRank(){
        String temp;
        int attempt = 0;

        do{
            if (attempt > 0)
                System.out.println("ERROR");
            System.out.println("Available Ranks");
            System.out.println("(1) Hokage ");
            System.out.println("(2) Anbu");
            System.out.println("(3) Jonin");
            System.out.println("Choose : ");
            temp = scanner.nextLine();
        }
        while(!temp.equals(1) && !temp.equals(2) && !temp.equals(3));
        if(temp.equals(1))
            return("Hokage");
        else if(temp.equals(2))
            return("Anbu");
        else
            return("Jonin");
    }
}