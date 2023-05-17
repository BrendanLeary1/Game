/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * ActionRecruit, similarly to the last two Actions, extends Action and recruits a troop
 * to the user's team.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */

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
        System.out.println(game.toString());
        game.changeTurn();
    }
}
