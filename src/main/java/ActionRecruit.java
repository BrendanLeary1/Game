public class ActionRecruit extends Action{

    public ActionRecruit(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction() {
        Player otherPlayer = game.getOpponentPlayer();
        Player recruitingPlayer = game.getCurrentPlayer();
        Unit recruited = game.getGameBoard().getSquares()[toRow][toCol].getUnit();
        otherPlayer.getPlayersTeam().removeUnitsFromTeam(recruited);
        recruitingPlayer.getPlayersTeam().addUnitsToTeam(recruited);
        game.changeTurn();
    }
}
