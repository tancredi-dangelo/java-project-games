package entities;

import enums.Genre;
import enums.Platform;

public class Videogame extends Game{

    // attributes
    private Platform platform;
    private int durationOfGaming;
    private Genre genre;

    // default constructor
    public Videogame() {
    }

    // constructor
    public Videogame(String gameId, String title, String yearOfPublication, int price, Platform platform, int durationOfGaming, Genre genre) {
        super(gameId, title, yearOfPublication, price);
        this.platform = platform;
        this.durationOfGaming = durationOfGaming;
        this.genre = genre;
    }

    // getters

    public Platform getPlatform() {
        return platform;
    }
    public int getDurationOfGaming() {
        return durationOfGaming;
    }
    public Genre getGenre() {
        return genre;
    }

    // setters

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
    public void setDurationOfGaming(int durationOfGaming) {
        this.durationOfGaming = durationOfGaming;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
