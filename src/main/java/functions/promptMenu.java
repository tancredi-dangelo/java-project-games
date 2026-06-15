package functions;

import static functions.InputHelpers.validateInt;
import static functions.actions.*;

public class promptMenu {

    public static void promptMenu() {

        while (true) {

            // print menu
            System.out.println("\n=== GAME MENU ===");
            System.out.println("1. Add game");
            System.out.println("2. Find game by ID");
            System.out.println("3. Delete game");
            System.out.println("4. Update game");
            System.out.println("5. Find games below price");
            System.out.println("6. Find table games by number of players");
            System.out.println("7. Print stats");
            System.out.println("0. Exit");

            // initialize choice
            int choice = validateInt("Choose: ");

            // switch on choice
            switch (choice) {

                case 1 -> addGame();
                case 2 -> findById();
                case 3 -> deleteGame();
                case 4 -> updateGame();
                case 5 -> findByPrice();
                case 6 -> findByPlayers();
                case 7 -> printStats();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }

    }
}
