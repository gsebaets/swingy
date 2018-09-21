package main.java.com.view;

import main.java.com.controller.PlayerController;
import main.java.com.model.PlayerModel;
import java.util.List;
import java.util.Scanner;

public class PlayerConsoleView extends Player_View implements Display {

    private PlayerController    playerController;
    private PlayerModel         playerModel;
    private Scanner             scanner;

    public PlayerConsoleView(){
    }

    private String  getPlayerRank(){
        String temp;
        int attempt = 0;

        do{
            if (attempt > 0) {
                System.out.println("ERROR");
            }
            System.out.println("\nAvailable Ranks");
            System.out.println("(1) Hokage ");
            System.out.println("(2) Anbu");
            System.out.println("(3) Jonin");
            System.out.print("\nChoose : ");
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
    public void selectPlayer(List<PlayerModel> players) {

    }

    public void createPlayer()
    {
        PlayerModel playerModel;
        String name, temp;
        int level;

        scanner = new Scanner(System.in);

        System.out.println("\nEnter player name : ");
        name = scanner.nextLine();
        System.out.println(getPlayerRank());
        System.out.println("Enter Level : ");
        temp = scanner.nextLine();
        level = Integer.parseInt(temp);
    }

    public int  choosePlayer(PlayerController controller)
    {
        return 0;
    }

    public void refresh() {

    }

    public void    startMenu(PlayerController playerController) {
        String temp;
        boolean valid;

        this.playerController = playerController;
        System.out.println("******START MENU******");
        System.out.println();
        do {
           // valid = false;
            System.out.println("======================");
            System.out.println("|| 1. Create Player ||");
            System.out.println("|| 2. Load Player   ||");
            System.out.println("======================");
            System.out.println();
            System.out.print("Option : ");
            scanner = new Scanner(System.in);
            temp = scanner.nextLine();
            valid = (temp.equals("1") || temp.equals("2"));

            if(!valid)
                System.out.println("\nInvalid Option (1 or 2)");
        }while(!valid);
        this.playerController.updatePlayerChoice(Integer.parseInt(temp));
     }
}