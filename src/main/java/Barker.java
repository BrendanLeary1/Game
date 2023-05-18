public abstract class Barker extends Unit {
    private int barkRange;

    public Barker(char symbol, String name, double health, double healthModifier, double damage,
                    double damageModifier, int luck, int xCor, int yCor, int movement,
                    int movementModifier, String teamColor, int barkRange){
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor);
        this.barkRange = barkRange;
    }

    public int getBarkRange(){return this.barkRange;}
    public void setBarkRange(int barkRange){this.barkRange = barkRange;}
    public abstract boolean validBarkPath(int fromRow, int fromCol, int toRow, int toCol);

}