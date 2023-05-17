// New Unit Modifications
public class SpikeUnit extends TomJerryUnit{
    int barkRange;

    public SpikeUnit(char symbol, String name, double health, double healthModifier, double damage,
                     double damageModifier, int luck, int xCor, int yCor, int movement,
                     int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding,
                     String teamColor, int numAttacks, int barkRange) {
        super(char symbol, String name, double health, double healthModifier, double damage,
        double damageModifier, int luck, int xCor, int yCor, int movement,
        int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding,
        String teamColor, int numAttacks);
        this.barkRange = barkRange;
    }

    public int getBarkRange() {
        return barkRange;
    }

    public void setBarkRange(int barkRange) {
        this.barkRange = barkRange;
    }

    @Override
    public boolean validBarkPath(int fromRow, int fromCol, int toRow, int toCol) {
        int upRange = fromRow-barkRange;
        int leftRange =
        if()
    }

}
