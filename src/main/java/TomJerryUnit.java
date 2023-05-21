/**
 * <h1>Lab3</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Lab3 provides practice with classes and creating
 * getters and setters for them.
 *
 * @author Brendan Leary
 *
 * @since 2023-03-07
 */
public class TomJerryUnit extends Attacker {
    private boolean homingRocket;
    private boolean offerCheese;
    private boolean hiding;

    public TomJerryUnit(char symbol, String name, double health, double healthModifier, double damage,
                        double damageModifier, int luck, int xCor, int yCor, int movement,
                        int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding,
                        String teamColor, int numAttacks) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor, numAttacks);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }
    public TomJerryUnit() {
        this('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, true, true, false, "none", 0);
    }
    public boolean canHomingRocket() {
        return this.homingRocket;
    }
    public boolean canOfferCheese() {
        return this.offerCheese;
    }
    public boolean isHiding() {
        return this.hiding;
    }
    public void setHomingRocket(boolean homingRocket) {
        this.homingRocket = homingRocket;
    }
    public void setOfferCheese(boolean offerCheese) {
        this.offerCheese = offerCheese;
    }
    public void setHiding(boolean hiding) {
        this.hiding = hiding;
    }
    public double dealDamage() {
        double damage = super.getDamage();
        double damageModifier = super.getDamageModifier();
        double totalDamage;
        totalDamage = damage + damageModifier;
        if (canHomingRocket()) {
            totalDamage += 10.0;
        }
        return totalDamage;
    }
    public void takeDamage(double damageTaken) {
        if (! (this.isHiding())) {
            health -= damageTaken;
        }
    }
    public TomJerryUnit spawn() {
        TomJerryUnit newTomJerry = new TomJerryUnit('t', "Tom and Jerry", 100.0,
                5.0, 25.0, 10.0, 0, 1, 1, 1,
                1, true, true, true, "none", 0);
        return newTomJerry;
    }

    public boolean canSpawn(){ return true; }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        return ((fromRow == toRow) && (fromRow == fromCol));
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        return ((fromRow == toRow) && (fromRow == fromCol));
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        if ((fromRow == toRow) && (fromRow == fromCol)) {
            return false;
        }
        return (((fromRow == toRow) && (fromCol != toCol)) ^ ((fromCol == toCol) && (
                ( (2 >= (toRow - fromRow)) && ((toRow - fromRow) >= 0) ) ||
                        ( (2 >= (fromRow - toRow)) && ((fromRow - toRow) >= 0)) )));

    }
}
