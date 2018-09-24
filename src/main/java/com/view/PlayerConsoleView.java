package com.view;


import com.controller.*;
import com.model.PlayerModel;
import java.util.*;
import javax.validation.*;

public class PlayerConsoleView extends Player_View implements Display {

    private PlayerController    playerController;
    private PlayerModel         playerModel;
    private Scanner             scanner;

    public PlayerConsoleView(){
    }

    private String  getPlayerRank(){
        String temp;

        do{

            System.out.println("\nAvailable Ranks");
            System.out.println("(1) Hokage ");
            System.out.println("(2) Anbu");
            System.out.println("(3) Jonin");
            System.out.print("\nChoose : ");
            temp = scanner.nextLine();
        }
        while(!temp.equals("1") && !temp.equals("2") && !temp.equals("3"));
        if(temp.equals("1"))
            return("Hokage");
        else if(temp.equals("2"))
            return("Anbu");
        else
            return("Jonin");
    }
    public void selectPlayer(List<PlayerModel> players) {

    }

    public void createPlayer()
    {
        PlayerModel playerModel;
        String name, temp, rank;
        int level;

        scanner = new Scanner(System.in);

        System.out.println("\nEnter player name : ");
        name = scanner.nextLine();
        rank = getPlayerRank();
        System.out.println(rank);
        System.out.println("Enter Level : ");
        temp = scanner.nextLine();
        level = Integer.parseInt(temp);
        PlayerModel hero = ArenaController.setStats(name, rank, level);
        if (!validatePlayer(hero))
            createPlayer();
        else{
            int wholeMap = ArenaController.buildArena(hero);
            while (ArenaController.randerGame(hero, wholeMap));
        }

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

     private boolean validatePlayer(PlayerModel playerModel)
     {
         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         Validator validator = factory.getValidator();

         Set<ConstraintViolation<PlayerModel>> constraintViolations = validator.validate(playerModel);
         if (constraintViolations.size() > 0 )
         {
             for (ConstraintViolation<PlayerModel> constraints : constraintViolations)
                 System.out.println(constraints);
             return (false);
         }
         return (true);
     }
}