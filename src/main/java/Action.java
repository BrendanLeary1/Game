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
