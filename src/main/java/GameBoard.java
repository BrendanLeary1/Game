import java.util.Random;

public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;
    public GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        this.setUpEmptyBoard();
    }

    public GameBoard() {}

    // Accessors
    public int getNumRows() {
        return this.numRows;
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public BoardSquare[][] getSquares() {
        return this.squares;
    }

    // Game Mechanic Methods
    public boolean inBounds(int row, int column) {
        return (row >= 0 && row < this.numRows) && (column >= 0 && column < this.numColumns);
    }

    private void setUpEmptyBoard() {
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j++) {
                if(i%2 == 0) {
                    if(j%2 == 0) {
                        this.squares[i][j] = new BoardSquare("black");
                    } else {
                        this.squares[i][j] = new BoardSquare("white");
                    }
                } else {
                    if(j%2 == 0) {
                        this.squares[i][j] = new BoardSquare("white");
                    } else {
                        this.squares[i][j] = new BoardSquare("black");
                    }
                }
            }
        }
    }

    public BoardSquare findRandomEmptySpace() {
        BoardSquare temp = this.squares[(int) (Math.random() * (numRows - 1))][(int) (Math.random() * (numColumns - 1))];
        boolean foundEmptySquare = false;
        while (! foundEmptySquare) {
            if (! temp.isEmptySpace()) {
                temp = this.squares[(int) (Math.random() * (numRows - 1))][(int) (Math.random() * (numColumns - 1))];
            }
            else {
                foundEmptySquare = true;
            }
        }
        return temp;
    }

    // toString method from instructions with added @Override
    // random board square when a piece ands on it,
    /**
     public void setNewPressurePlate() {
     Random random = new Random();
     int randomRow = random.nextInt(numRows);
     int randomCol = random.nextInt(numColumns);
     BoardSquare randomSquare = squares[randomRow][randomCol];
     randomSquare.setPressurePlate(true);

     Player opponentPlayer = game.getOpponentPlayer();
     Team enemyTeam = opponentPlayer.getPlayersTeam();
     if (enemyTeam.getTeamUnits().size() > 0) {
     int randomIndex = random.nextInt(enemyTeam.getTeamUnits().size());
     Unit randomAttacker = enemyTeam.getTeamUnits().get(randomIndex);
     enemyTeam.removeUnit(randomAttacker);
     }

     BoardSquare newPressurePlate = findRandomEmptySpace();
     newPressurePlate.setPressurePlate(true);
     }
     **/

    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
