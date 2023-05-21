/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * ActionSpawn, similarly to ActionMove, extends Action and spawns a new unit.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */

public class ActionSpawn extends Action{
    public ActionSpawn(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction() {
        // updated to prevent SpikeUnit from spawning
        if (! (game.getGameBoard().getSquares()[fromRow][fromCol].getUnit() instanceof SpikeUnit) &&
                ! (game.getGameBoard().getSquares()[fromRow][fromCol].getUnit() instanceof ScoobyDooUnit)) {
            Unit guy = game.getGameBoard().getSquares()[fromRow][fromCol].getUnit().spawn();
            game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(guy);
            game.getGameBoard().getSquares()[toRow][toCol].setUnit(guy);
            System.out.println(game.toString());
            game.changeTurn();
        } else if (game.getGameBoard().getSquares()[fromRow][fromCol].getUnit() instanceof ScoobyDooUnit) {
            ScoobyDooUnit scooby = (ScoobyDooUnit) game.getBoardSquares()[fromRow][fromCol].getUnit().spawn();
            game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(scooby);
            game.getGameBoard().findRandomEmptySpace().setUnit(scooby);
            System.out.println(game.toString());
            game.changeTurn();
        }
    }

    @Override
    public String toString() {
        return game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team's " +
                game.getBoardSquares()[fromRow][fromCol].getUnit().getName() +
                " unit spawns a new " + game.getBoardSquares()[toRow][toCol].getUnit().getName() +
                " at " + toRow + "," + toCol;
    }


}
