/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * ActionAttack is similar to the previous three Actions in that it extends Action and
 * lets a troop attack another, but it also requires a check of the type of Unit that is
 * being attacked, as BartSimpsonUnit will immediately be removed while TomJerryUnit will
 * require its health to be lowered to 0 before removal.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */

public class ActionAttack extends Action{
    public ActionAttack(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction() {
        Unit attacker = game.getGameBoard().getSquares()[fromRow][fromCol].getUnit();
        Unit attacked = game.getGameBoard().getSquares()[toRow][toCol].getUnit();
        Player otherPlayer = game.getOpponentPlayer();
        if (attacker instanceof Attacker) {
            if (attacked instanceof TomJerryUnit) { // This also includes SpikeUnit
                ((TomJerryUnit) attacked).takeDamage(((TomJerryUnit) attacker).dealDamage());
                // Added line below to make sure there's not an invisible army of TomJerryUnits
                ((TomJerryUnit) attacker).setHiding(false);
                if (attacked.getHealth() <= 0) {
                    game.getGameBoard().getSquares()[toRow][toCol].removeUnit();
                    otherPlayer.getPlayersTeam().removeUnitsFromTeam(attacked);
                    game.getGameBoard().getSquares()[fromRow][fromCol].removeUnit();
                    game.getGameBoard().getSquares()[toRow][toCol].setUnit(attacker);
                    game.changeTurn();
                    System.out.println(game.toString());
                }
                else {
                    System.out.println("Did not defeat " + attacked.getName() + "! It has " +
                            attacked.getHealth() + " more health.");
                    game.changeTurn();
                    System.out.println(game.toString());
                }
            } else if (!(attacked instanceof Attacker)) {
                // changed to include both BartSimpson and ScoobyDoo Units
                game.getGameBoard().getSquares()[toRow][toCol].removeUnit();
                otherPlayer.getPlayersTeam().removeUnitsFromTeam(attacked);
                game.getGameBoard().getSquares()[fromRow][fromCol].removeUnit();
                game.getGameBoard().getSquares()[toRow][toCol].setUnit(attacker);
                game.changeTurn();
                System.out.println(game.toString());
            }
        }
    }

    @Override
    public String toString() {
        return game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team's " +
                game.getBoardSquares()[toRow][toCol].getUnit().getName() + " unit defeated the piece at " +
                toRow + "," + toCol;
    }
}

