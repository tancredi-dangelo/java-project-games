package tancredi;

import collections.GamesCollection;
import entities.Game;
import entities.TableGame;
import entities.Videogame;
import enums.Genre;
import enums.Platform;
import exceptions.EmptyListException;

import java.util.List;
import java.util.Scanner;



public class Main {

    private static final GamesCollection games = new GamesCollection();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // initialize games

        games.addGame(new Videogame("VG001", "Minecraft", "2011", 30, Platform.PC, 200, Genre.SURVIVAL));
        games.addGame(new Videogame("VG002", "The Witcher 3", "2015", 40, Platform.PS4, 120, Genre.RPG));
        games.addGame(new Videogame("VG003", "Elden Ring", "2022", 70, Platform.PS5, 150, Genre.RPG));
        games.addGame(new Videogame("VG004", "Red Dead Redemption 2", "2018", 60, Platform.XBOX, 80, Genre.ADVENTURE));
        games.addGame(new Videogame("VG005", "Call of Duty", "2024", 80, Platform.PS5, 50, Genre.SHOOTER));

        games.addGame(new TableGame("TG001", "Chess", "1475", 20, 2, 60));
        games.addGame(new TableGame("TG002", "Monopoly", "1935", 30, 6, 180));
        games.addGame(new TableGame("TG003", "Catan", "1995", 45, 4, 90));
        games.addGame(new TableGame("TG004", "Risk", "1957", 40, 6, 240));
        games.addGame(new TableGame("TG005", "Scrabble", "1948", 25, 4, 90));


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
            System.out.print("Choose: ");

            // initialize choice
            int choice = scanner.nextInt();
            scanner.nextLine();


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


    // ------------- ACTIONS ---------------------

    private static void addGame() {

        System.out.println("Type (V/T): ");
        String type = scanner.nextLine().toUpperCase();

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Year: ");
        String year = scanner.nextLine();

        System.out.print("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        if (type.equals("V")) {

            System.out.print("Platform: ");
            Platform platform = Platform.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Genre: ");
            Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Hours: ");
            int hours = scanner.nextInt();
            scanner.nextLine();

            games.addGame(new Videogame(id, title, year, price, platform, hours, genre));
        }

        else {

            System.out.print("Players: ");
            int players = scanner.nextInt();

            System.out.print("Avg duration: ");
            int duration = scanner.nextInt();
            scanner.nextLine();

            games.addGame(new TableGame(id, title, year, price, players, duration));
        }
    }

    private static void findById() {
        System.out.print("Enter ID: ");
        Game g = games.getGameById(scanner.nextLine());

        if (g != null) System.out.println(g);
    }

    private static void deleteGame() {
        System.out.print("Enter ID: ");
        games.deleteGame(scanner.nextLine());
    }

    private static void updateGame() {
        System.out.print("Enter ID: ");
        games.update(scanner.nextLine());
    }

    private static void findByPrice() {
        try {
            System.out.print("Max price: ");
            int price = scanner.nextInt();
            scanner.nextLine();

            List<Game> result = games.getGamesByPrice(price);
            result.forEach(System.out::println);

        } catch (EmptyListException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void findByPlayers() {
        System.out.print("Players: ");
        int n = scanner.nextInt();

        games.getGameByNumberOfPlayers(n).forEach(System.out::println);
    }

    private static void printStats() {
        games.printStats();
    }
}