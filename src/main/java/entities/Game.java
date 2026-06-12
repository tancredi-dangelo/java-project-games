package entities;

public abstract class Game {

    // attributes
    private String gameId;
    private String title;
    private String yearOfPublication;
    private int price;

    // default constructor
    public Game() {
    }

    // constructor
    public Game(String gameId, String title, String yearOfPublication, int price) {
        this.gameId = gameId;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
    }

    // getters

    public String getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public int getPrice() {
        return price;
    }

    // setter

    public void setPrice(int price) {
        this.price = price;
    }


    // methods


}
