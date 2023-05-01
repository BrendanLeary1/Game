public class ActionSpawn extends Action{
    public ActionSpawn(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction() {
        Unit guy = game.getGameBoard().getSquares()[fromRow][fromCol].getUnit().spawn();
        game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(guy);
        game.getGameBoard().getSquares()[toRow][toCol].setUnit(guy);
        game.changeTurn();
    }


}
