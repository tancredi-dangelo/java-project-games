package collections;

import entities.Game;

import entities.TableGame;
import entities.Videogame;

import enums.Genre;
import enums.Platform;

import exceptions.EmptyListException;
import exceptions.IdAlreadyUsedException;
import exceptions.IdNotFoundException;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static functions.InputHelpers.*;

public class GamesCollection {

    // initialize main games ArrayList

    public final List<Game> games = new ArrayList<>();


    // --------------- METHODS ----------------

    // add a game method
    public void addGame(Game game) {
        try {
            boolean idExists = games.stream().anyMatch(g -> g.getGameId().equals(game.getGameId()));
            if (idExists) throw new IdAlreadyUsedException("A game with this Id already exists");
            games.add(game);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    // find a game by id method
    public Game getGameById(String id) {
        try {
            return games.stream()
                    .filter(g -> g.getGameId().equals(id))
                    .findFirst()
                    .orElseThrow(() ->
                            new IdNotFoundException(
                                    "There are no games with the provided Id."
                            ));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }


    // find a game by price method
    public List<Game> getGamesByPrice(int price) throws EmptyListException {

        List<Game> priceTagGames = games.stream()
                .filter(g -> g.getPrice() < price)
                .toList();

        if (priceTagGames.isEmpty()) {
            throw new EmptyListException("There are no games below that price.");
        }

        return priceTagGames;
    }

    // find a game by number of players method
    public List<Game> getGameByNumberOfPlayers(int nPlayers) {
        return games.stream()
                .filter(g -> g instanceof TableGame tg)
                .filter(tg -> ((TableGame) tg).getNumberOfPlayers() == nPlayers)
                .toList();
    }


    // delete a game method
    public void deleteGame(String id) {
        try {
            Game gameToRemove = getGameById(id);
            games.remove(gameToRemove);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    // update a game method
    public void update(String id) {

        Scanner scanner = new Scanner(System.in);

        try {
            Game gameToUpdate = getGameById(id);

            System.out.println("--------- Update game " + id + " ----------");

            String title = validateString("Update game title: ");
            gameToUpdate.setTitle(title);

            int price = validateInt("Update price: ");
            gameToUpdate.setPrice(price);

            String yearPublication = validateString("Update year of publication: ");
            gameToUpdate.setYearOfPublication(yearPublication);

            if (gameToUpdate instanceof TableGame) {

                int nPeople = validateInt("Update number of people required to play: ");
                ((TableGame) gameToUpdate).setNumberOfPlayers(nPeople);

                int avgDuration = validateInt("Update average duration of the game:");
                ((TableGame) gameToUpdate).setAverageGameDuration(avgDuration);
            }

            if (gameToUpdate instanceof Videogame) {


                Platform platform = validatePlatform("Platform: ");
                ((Videogame) gameToUpdate).setPlatform(platform);


                Genre genre = validateGenre("Update genre: ");
                ((Videogame) gameToUpdate).setGenre(genre);

                int hoursGameplay = validateInt("Update hours of gameplay: ");
                ((Videogame) gameToUpdate).setDurationOfGaming(hoursGameplay);

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    // games collections print state method
    public void printStats() {

        int tablegamesSize = games.stream()
                .filter(g -> g instanceof TableGame tg)
                .toList()
                .size();
        int videogamesSize = games.stream()
                .filter(g -> g instanceof Videogame tg)
                .toList()
                .size();

        Game mostExpensiveGame = games.stream()
                .max(Comparator.comparingInt(Game::getPrice))
                .orElse(null);

        double averagePrice = games.stream()
                .mapToInt(Game::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("Total games: " + games.size()
                + ", Videogames: " + videogamesSize
                + ", Table Games: " + tablegamesSize
                + ", Most expensive: " + mostExpensiveGame
                + ", Average price of the collection: " + averagePrice);
    }



}
