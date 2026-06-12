package entities;

public class TableGame extends Game {

    // attributes
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


    // getters

    public int getAverageGameDuration() {
        return averageGameDuration;
    }
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }




    // setters

    public void setAverageGameDuration(int averageGameDuration) {
        this.averageGameDuration = averageGameDuration;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }


    // methods

    @Override
    public String toString() {
        return ("Type: Table Game, Title: " + getTitle()
                + ", Year of publication: " + getYearOfPublication()
                + ", Average Duration: " + getAverageGameDuration()
                + ", Number Of Players: " + getNumberOfPlayers()
                + ", Price: " + getPrice());
    }

}
