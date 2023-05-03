/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Action is an abstract class that provides the foundation for the four classes
 * that allow troops to perform the corresponding action.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */
public abstract class Action {
    public Game game;
    public int fromRow;
    public int fromCol;
    public int toRow;
    public int toCol;

    public Action(Game game, int fromRow, int fromCol, int toRow, int toCol) {
        this.game = game;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    public abstract void performAction();
}
