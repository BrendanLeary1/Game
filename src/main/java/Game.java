import java.util.Collections;

public class Game {
    private GameBoard gameBoard;
    private Player playerOne;
    private Player playerTwo;

    private void MakeBoard(int rows, int cols){
        GameBoard board = new GameBoard(rows, cols);

        for (Unit unit : playerOne.getPlayersTeam().getTeamUnits()) {
            BoardSquare square = gameBoard.findRandomEmptySpace();
            square.setUnit(unit);
            //unit.setSquare(square);
        }
        for (Unit unit : playerTwo.getPlayersTeam().getTeamUnits()) {
            BoardSquare square = gameBoard.findRandomEmptySpace();
            square.setUnit(unit);
            //unit.setSquare(square);
        }
    }
    public Game(int rows, int cols, Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameBoard  = new GameBoard(rows, cols);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player getCurrentPlayer() {
        if (playerTwo.isTurn()){
            return playerTwo;
        }
        return playerOne;
    }

    public Player getOpponentPlayer() {
        if (!playerTwo.isTurn()){
            return playerTwo;
        }
        return playerOne;
    }

    public BoardSquare[][] getBoardSquares() {
        return gameBoard.getSquares();
    }

    public void changeTurn(){
        getCurrentPlayer().setTurn(false);
        getOpponentPlayer().setTurn(true);
    }
    public boolean isTurn(Player p){
        if (p.isTurn()){return true;}
        return false;
    }
    // We have to change GET PLAYER TEAM to GET PLAYERS TEAM

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getCurrentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getPlayersTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }

    public boolean isAWinner(){
        //XOR operator
        if (((playerOne.getPlayersTeam().getTeamUnits().size() > 0) && (playerTwo.getPlayersTeam().getTeamUnits().size() == 0))
                ||
                ((playerOne.getPlayersTeam().getTeamUnits().size() == 0) && (playerTwo.getPlayersTeam().getTeamUnits().size() > 0 ))){
            return true;
        }
        return false;
    }

    public Player getWinner(){
        if(playerOne.getPlayersTeam().getTeamUnits().size() > playerTwo.getPlayersTeam().getTeamUnits().size()) {
            System.out.println("Player 1 is Winning!");
            return playerOne;
        } else if(playerTwo.getPlayersTeam().getTeamUnits().size() > playerOne.getPlayersTeam().getTeamUnits().size()) {
            System.out.println("Player 2 is Winning!");
            return playerTwo;
        } else {
            System.out.println("Player 1 And Player 2 Are Tied! returning current player");
            return getCurrentPlayer();
        }

    }

    public boolean isGameEnded(){
        if (((playerOne.getPlayersTeam().getTeamUnits().size()) == 0) || (playerTwo.getPlayersTeam().getTeamUnits().size() == 0)){
            return true;
        }
        return false;
    }



}