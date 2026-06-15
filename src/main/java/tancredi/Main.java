package tancredi;

import collections.GamesCollection;
import entities.TableGame;
import entities.Videogame;
import enums.Genre;
import enums.Platform;

import java.util.Scanner;

import static functions.InputHelpers.validateInt;
import static functions.actions.*;
import static functions.promptMenu.promptMenu;


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


        promptMenu();


    }

}



