package com;

import com.controller.PlayerController;
import com.controller.databaseController;
import com.view.*;

public class swingy {

    public static void main(String[] args) {

        databaseController.createDB();
        databaseController.initDB();


        PlayerController playerController;
        Display display;


        if (args.length > 0) {
            if (args[0].equals("console")) {
                display = new PlayerConsoleView();
                playerController = new PlayerController(display);
                playerController.startMenu();
            }
            else {
                System.out.println("Invalid Choice");
                return ;
            }
        }
        else {
            System.out.println("Revert to Console");
            display = new PlayerConsoleView();
        }
        if (display == null) {
            System.out.println("Display Error");
            return ;
        }
    }
}
