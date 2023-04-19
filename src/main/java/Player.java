/**
 * <h1>Lab4</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The Player class holds the number of the player, whether or not it's the player's
 * turn, and a TomJerryUnit controlled by the player. It can also set and get each
 * parameter, as well as creating three types of Player units: one with no parameters,
 * one with a player number and TomJerryUnit as parameters, and one with all 3 as parameters.
 *
 * @author Brendan Leary
 * @since 2023-03-21
 */
public class Player {
    private int playerNumber;
    private boolean turn;
    private Team playerTeam;

    public int getPlayerNumber() {
        return this.playerNumber;
    }
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    public boolean isTurn() {
        return this.turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    public Team getPlayersTeam() {
        return this.playerTeam;
    }
    public void setPlayersTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
    }

    public Player(int playerNumber, boolean turn, Team playerTeam) {
        this.playerNumber = playerNumber;
        this.turn = turn;
        this.playerTeam = playerTeam;
    }
    public Player(int playerNumber, Team playerTeam) {
        this.playerNumber = playerNumber;
        this.turn = false;
        this.playerTeam = playerTeam;
    }
    public Player() {
        this.playerNumber = 0;
        this.turn = false;
        this.playerTeam = new Team();
    }

}
