import java.util.Collections;
import java.util.Random;

public class Game {
    private GameBoard gameBoard;
    private Player playerOne;
    private Player playerTwo;

    private void initializeGameBoard(int rows, int cols) {
        this.gameBoard = new GameBoard(rows, cols);

        for (Unit unit : playerOne.getPlayersTeam().getTeamUnits()) {
            BoardSquare square = this.gameBoard.findRandomEmptySpace();
            square.setUnit(unit);
            //unit.setSquare(square);
        }
        for (Unit unit : playerTwo.getPlayersTeam().getTeamUnits()) {
            BoardSquare square = this.gameBoard.findRandomEmptySpace();
            square.setUnit(unit);
            //unit.setSquare(square);
        }
        //make plate
        //for sake of example
        this.gameBoard.getSquares()[1][1].setPlate(true);
        //this.gameBoard.findRandomEmptySpace().setPlate(true);
    }

    public Game(int rows, int cols, Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        initializeGameBoard(rows, cols);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player getCurrentPlayer() {
        if (playerTwo.isTurn()) {
            return playerTwo;
        }
        return playerOne;
    }

    public Player getOpponentPlayer() {
        if (!playerTwo.isTurn()) {
            return playerTwo;
        }
        return playerOne;
    }

    public BoardSquare[][] getBoardSquares() {
        return gameBoard.getSquares();
    }

    public void changeTurn() {
        if(playerOne.isTurn()) {
            playerOne.setTurn(false);
            playerTwo.setTurn(true);
        } else if(playerTwo.isTurn()) {
            playerTwo.setTurn(false);
            playerOne.setTurn(true);
        }
    }

    public boolean isTurn(Player p) {
        if (p.isTurn()) {
            return true;
        }
        return false;
    }
    // We have to change GET PLAYER TEAM to GET PLAYERS TEAM

    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns() * 8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns() * 8, "*")))
                .append("\n" + getCurrentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns() * 8, "*")))
                .append("\n" + getOpponentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns() * 8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getPlayersTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }


    // Updated these three methods to follow the new win condition
    public boolean isAWinner() {
        //XOR operator
        if ((playerOne.getPlayersTeam().getNumAttackers() == 0) ^ (playerTwo.getPlayersTeam().getNumAttackers() == 0)) {
            return true;
        }
        return false;
    }

    public Player getWinner() {
        if ((playerOne.getPlayersTeam().getNumAttackers() > 0) && (playerTwo.getPlayersTeam().getNumAttackers() == 0)) {
            System.out.println("Player 1 Wins!");
            return playerOne;
        } else if ((playerTwo.getPlayersTeam().getNumAttackers() > 0) && (playerOne.getPlayersTeam().getNumAttackers() == 0)) {
            System.out.println("Player 2 Wins!");
            return playerTwo;
        } else {
            System.out.println("Game is still ongoing.");
            return null;
        }

    }

    public boolean isGameEnded() {
        if ((playerOne.getPlayersTeam().getNumAttackers() == 0) || (playerTwo.getPlayersTeam().getNumAttackers() == 0)) {
            return true;
        }
        return false;
    }

    public void setNewPressurePlate() {
        // Choose a random BoardSquare
        BoardSquare randomSquare = gameBoard.findRandomEmptySpace();

        BoardSquare[][] board =this.gameBoard.getSquares();
        // Remove a random attacker from the enemy team
        Player currentPlayer = getCurrentPlayer();
        Player opponentPlayer = getOpponentPlayer();
        Team opponentTeam = opponentPlayer.getPlayersTeam();

         Random rand = new Random();
         int randomIndex = rand.nextInt(opponentTeam.getTeamUnits().size());
         Unit unitToRemove = opponentTeam.getTeamUnits().get(randomIndex);

        for (int i = 0; i < this.gameBoard.getNumRows(); i++) {
            for (int j = 0; j < this.gameBoard.getNumColumns(); j++) {
                if(board[i][j].getUnit()==unitToRemove){
                    board[i][j].removeUnit();
                }
            }
        }

         opponentTeam.removeUnitsFromTeam(unitToRemove);


        //opponentTeam.removeMostRecentAttacker();


        // Choose a new random BoardSquare as a PressurePlate
        BoardSquare pressurePlate = gameBoard.findRandomEmptySpace();
        pressurePlate.setPlate(true);


    }
}
