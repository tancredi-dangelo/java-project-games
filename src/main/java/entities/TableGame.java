package entities;

public class TableGame extends Game{
    private int numberOfPlayers;
    private int averageGameDuration;

    // default constructor
    public TableGame() {
    }

    // constructor
    public TableGame(String gameId, String title, String yearOfPublication, int price, int numberOfPlayers, int averageGameDuration) {
        super(gameId, title, yearOfPublication, price);
        this.numberOfPlayers = numberOfPlayers;
        this.averageGameDuration = averageGameDuration;
    }

    // getters and setters

    public int getAverageGameDuration() {
        return averageGameDuration;
    }

    public void setAverageGameDuration(int averageGameDuration) {
        this.averageGameDuration = averageGameDuration;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
