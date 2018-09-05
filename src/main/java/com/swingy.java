package main.java.com;

import main.java.com.controller.PlayerController;
import main.java.com.view.*;

public class swingy {

    public static void main(String[] args) {

        PlayerController playerController;
        Display display;

        if (args.length > 0) {
            if (args[0].equals("console")) {
                display = new PlayerConsoleView() {
                    @Override
                    public void refresh() {

                    }
                };
            }
            else {
                System.out.println("Invalid Choice");
                return ;
            }
        }
        else {
            System.out.println("Revert to Console");
            display = new PlayerConsoleView() {
                @Override
                public void refresh() {

                }
            };
        }
        if (display == null) {
            System.out.println("Display Error");
            return ;
        }
    }
}
