package functions;

import collections.GamesCollection;
import entities.Game;
import entities.TableGame;
import entities.Videogame;
import enums.Genre;
import enums.Platform;
import exceptions.EmptyListException;

import java.util.List;
import java.util.Scanner;

import static functions.InputHelpers.*;

public class actions {

    static Scanner scanner = new Scanner(System.in);
    static GamesCollection games = null;

    public static void addGame() {

        String type = validateString("Type (V/T): ").toUpperCase();
        String id = validateString("ID: ");
        String title = validateString("Title: ");
        String year = validateString("Year: ");
        int price = validateInt("Price: ");

        // check if it's videogame
        if (type.equals("V")) {

            Platform platform = validatePlatform("Platform: ");
            Genre genre = validateGenre("Genre: ");
            int hours = validateInt("Hours: ");

            games.addGame(new Videogame(id, title, year, price, platform, hours, genre));
        }

        // check if it's table game
        else {

            int players = validateInt("Players: ");
            int duration = validateInt("Avg duration: ");

            games.addGame(new TableGame(id, title, year, price, players, duration));
        }
    }

    public static void findById() {

        Game g = games.getGameById(validateString("Enter ID: "));
        if (g != null) System.out.println(g);
    }

    public static void deleteGame() {
        games.deleteGame(validateString("Enter ID: "));
    }

    public static void updateGame() {
        games.update(validateString("Enter ID: "));
    }

    public static void findByPrice() {
        try {

            int price = validateInt("Max price: ");
            List<Game> result = games.getGamesByPrice(price);
            result.forEach(System.out::println);

        } catch (EmptyListException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void findByPlayers() {
        int n = validateInt("Players: ");
        games.getGameByNumberOfPlayers(n).forEach(System.out::println);
    }

    public static void printStats() {
        games.printStats();
    }

}
