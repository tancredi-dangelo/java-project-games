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

public class GamesCollection {

    // initialize main games ArrayList

    private List<Game> games = new ArrayList<>();


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

            System.out.println("Update game title: ");
            String title = scanner.next();
            gameToUpdate.setTitle(title);

            System.out.println("Update price: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            gameToUpdate.setPrice(price);

            System.out.println("Update year of publication: ");
            String yearPublication = scanner.next();
            gameToUpdate.setYearOfPublication(yearPublication);

            if (gameToUpdate instanceof TableGame) {

                System.out.println("Update number of people required to play: ");
                int nPeople = scanner.nextInt();
                scanner.nextLine();
                ((TableGame) gameToUpdate).setNumberOfPlayers(nPeople);

                System.out.println("Update average duration of the game:");
                int avgDuration = scanner.nextInt();
                scanner.nextLine();
                ((TableGame) gameToUpdate).setAverageGameDuration(avgDuration);
            }

            if (gameToUpdate instanceof Videogame) {

                System.out.println("Update platform: ");
                String platformInput = scanner.next().toUpperCase();
                Platform platform = Platform.valueOf(platformInput);
                ((Videogame) gameToUpdate).setPlatform(platform);

                System.out.println("Update genre: ");
                String genreInput = scanner.next().toUpperCase();
                Genre genre = Genre.valueOf(genreInput);
                ((Videogame) gameToUpdate).setGenre(genre);

                System.out.println("Update hours of gameplay: ");
                int hoursGameplay = scanner.nextInt();
                scanner.nextLine();
                ((Videogame) gameToUpdate).setDurationOfGaming(hoursGameplay);

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // call to string method
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
                .max(Comparator.comparingInt(Game::getPrice));

        System.out.println("Total games: " + games.size() + ", Videogames: " + videogamesSize + ", Table Games: " + tablegamesSize + );
    }


    // validation helpers




}
