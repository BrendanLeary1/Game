public abstract class Action {
    public Game actionGame;
    public int fromRow;
    public int fromCol;
    public int toRow;
    public int toCol;

    public Action(Game actionGame, int fromRow, int fromCol, int toRow, int toCol) {
        this.actionGame = actionGame;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    public abstract void performAction();
}
