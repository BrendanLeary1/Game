/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * ActionMove is a class that extends Action. All it does is move a piece
 * from one square to another.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */

public class ActionMove extends Action{
    public ActionMove(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction() {
        game.getGameBoard().getSquares()[toRow][toCol].setUnit(game.getGameBoard().getSquares()[fromRow][fromCol].getUnit());
        game.getGameBoard().getSquares()[fromRow][fromCol] = null;
        game.changeTurn();
    }


}
