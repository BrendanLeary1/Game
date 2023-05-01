public class ActionMove extends Action{
    public ActionMove(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction() {
        game.getGameBoard().getSquares()[toRow][toCol].setUnit(game.getGameBoard().getSquares()[fromRow][fromCol]);
        game.getGameBoard().getSquares()[fromRow][fromCol] = null;
        game.changeTurn();
    }


}
