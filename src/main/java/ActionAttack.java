public class ActionAttack extends Action{
    public ActionAttack(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction() {
        Unit attacker = game.getGameBoard().getSquares()[fromRow][fromCol].getUnit();
        Unit attacked = game.getGameBoard().getSquares()[toRow][toCol].getUnit();
        Player otherPlayer = game.getOpponentPlayer();
        if (attacker instanceof TomJerryUnit) {
            if (attacked instanceof TomJerryUnit) {
                ((TomJerryUnit) attacked).takeDamage(((TomJerryUnit) attacker).dealDamage());
                if (attacker.getHealth() <= 0) {
                    game.getGameBoard().getSquares()[toRow][toCol].removeUnit();
                    otherPlayer.getPlayersTeam().removeUnitsFromTeam(attacked);
                    game.getGameBoard().getSquares()[fromRow][fromCol].removeUnit();
                    game.getGameBoard().getSquares()[toRow][toCol].setUnit(attacker);

                }
            } else if (attacked instanceof BartSimpsonUnit) {
                game.getGameBoard().getSquares()[toRow][toCol].removeUnit();
                otherPlayer.getPlayersTeam().removeUnitsFromTeam(attacked);
                game.getGameBoard().getSquares()[fromRow][fromCol].removeUnit();
                game.getGameBoard().getSquares()[toRow][toCol].setUnit(attacker);
            }
        }
        game.changeTurn();
    }
}
