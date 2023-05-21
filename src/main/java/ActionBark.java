/**
 * // New Action Modifications
 * <h1>Final project</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * ActionBark is a class that extends Action. It allows for a Unit that extends it
 * to "bark" at other Units, which can scare them into backing up one space from the barking Unit
 * only if they are in a cardinal direction (not diagonal) from the barking Unit and in the Unit's bark range.
 * If the opposing unit is on the edge of the board and barked at, they are removed from the
 * board.
 *
 * Visual of Barker 'S' with a bark range of 1 (range represented by 'b')
 *   b
 * b s b
 *   b
 *
 * Visual of Barker 'S' with a bark range of 3 (range represented by 'b')
 * and an opposing piece within its range 'O'
 *  // Note that an opposing piece can be anywhere inside a barking Unit's
 *  // range, not just at its edge.
 *       b
 *       b
 *       b
 * b b b S b b O
 *       b
 *       b
 *       b
 *
 * Visual after 'S' barks at 'O'
 *       b
 *       b
 *       b
 * b b b S b b b O
 *       b
 *       b
 *       b
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-18
 */

public class ActionBark extends Action {
    public ActionBark(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction() {
        Unit barker = game.getGameBoard().getSquares()[fromRow][fromCol].getUnit();
        if (barker instanceof Barker) {
            if (barker instanceof ScoobyDooUnit) {
                char direction = ((ScoobyDooUnit) barker).barkDirection(fromRow, fromCol, toRow, toCol);
                Unit temp = game.getGameBoard().getSquares()[toRow][toCol].getUnit();
                game.getGameBoard().getSquares()[toRow][toCol].removeUnit();
                int colLength = game.getBoardSquares().length;
                int rowLength = game.getBoardSquares()[0].length;
                if((direction == 'L' && toCol == 0) || (direction == 'R' && toCol == colLength - 1)
                        || (direction == 'U' && toRow == 0) || (direction == 'D' && toRow == rowLength - 1)) {
                    // New Rule Modification
                    // If the opposing player is barked off of the board,
                    // they lose their piece and also lose a turn (the turn is not switched back to them)
                    System.out.println(game.toString());
                } else {
                    if (direction == 'L') {
                        game.getGameBoard().getSquares()[toRow][toCol - 1].setUnit(temp);
                    } else if (direction == 'R') {
                        game.getGameBoard().getSquares()[toRow][toCol + 1].setUnit(temp);
                    } else if (direction == 'U') {
                        game.getGameBoard().getSquares()[toRow - 1][toCol].setUnit(temp);
                    } else if (direction == 'D') {
                        game.getGameBoard().getSquares()[toRow + 1][toCol].setUnit(temp);
                    }
                    System.out.println(game.toString());
                    game.changeTurn();
                }
            }
        }
        System.out.println(game.toString());
        game.changeTurn();
    }

    @Override
    public String toString() {
        return game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team's " +
                game.getBoardSquares()[fromRow][fromCol].getUnit().getName() + " unit barks from " +
                fromRow + "," + fromCol + "and is barking at " +
                game.getOpponentPlayer().getPlayersTeam().getTeamColor() + " team's " +
                game.getBoardSquares()[toRow][toCol].getUnit().getName() + " unit at " + toRow +
                "," + toCol;
    }
}
