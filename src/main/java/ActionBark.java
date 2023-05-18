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
                if (direction == 'L') {
                    game.getGameBoard().getSquares()[toRow][toCol-1].setUnit(temp);
                } else if (direction == 'R') {
                    game.getGameBoard().getSquares()[toRow][toCol+1].setUnit(temp);
                } else if (direction == 'U') {
                    game.getGameBoard().getSquares()[toRow-1][toCol].setUnit(temp);
                } else if (direction == 'D') {
                    game.getGameBoard().getSquares()[toRow+1][toCol].setUnit(temp);
                }
                System.out.println(game.toString());
                game.changeTurn();
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
