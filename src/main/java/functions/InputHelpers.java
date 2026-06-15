package functions;

import enums.Genre;
import enums.Platform;

import java.util.Scanner;

public class InputHelpers {

    private static final Scanner scanner = new Scanner(System.in);

    public static int validateInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static String validateString(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                String input = scanner.nextLine();
                if (input.isEmpty()) throw new RuntimeException("Input must be at least 1 character long.");
                if (input.length() > 30) throw new RuntimeException("Max. 30 characters allowed.");
                return input;
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }

    public static Platform validatePlatform(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Platform.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.println("Platform not available. Choose from: PC, PS4, PS5, XBOX, NINTENDO");
            }
        }
    }

    public static Genre validateGenre(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Genre.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.println("Genre not available. Choose from: ACTION, ADVENTURE, RPG, STRATEGY, SIMULATION, SPORTS, SHOOTER, SURVIVAL");
            }
        }
    }
}