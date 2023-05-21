/**
 * // New Unit Modification
 * <h1>Final Project</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The SpikeUnit class extends TomJerryUnit.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-18
 */

public class SpikeUnit extends TomJerryUnit{

    public SpikeUnit(char symbol, String name, double health, double healthModifier, double damage,
                     double damageModifier, int luck, int xCor, int yCor, int movement,
                     int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding,
                     String teamColor, int numAttacks) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement,
        movementModifier, homingRocket, offerCheese, hiding, teamColor, numAttacks);
    }

    public SpikeUnit() {
        this('S', "Spike", 125.0, 0.0, 40.0, 0.0,
                0, 5, 5, 1, 0, false, false,
                false, "none", 0);
    }

    @Override
    public double dealDamage() {
        return super.getDamage() + super.getDamageModifier();
    }

    @Override
    public void takeDamage(double damageTaken) {
        this.health -= damageTaken;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        if ((fromRow == toRow) && (fromRow == fromCol)) {
            return false;
        }
        return ( ((fromCol == toCol) && (( (4 >= (toRow - fromRow)) && ((toRow - fromRow) >= 0) ) ||
                        ( (4 >= (fromRow - toRow)) && ((fromRow - toRow) >= 0)))) ^
                (((fromRow == toRow) && (((2 >= (toCol - fromCol)) && ((toCol - fromCol) >= 0) ) ||
                        ( (2 >= (fromCol - toCol)) && ((fromCol - toCol) >= 0))))) );
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }

    @Override
    public boolean validAttackPath(int fromRow, int fromCol, int toRow, int toCol) {
        if ((fromRow == toRow) && (fromRow == fromCol)) {
            return false;
        }
        return ((((2 >= (toRow - fromRow)) && ((toRow - fromRow) >= 0)) ||
                    ((2 >= (fromRow - toRow)) && ((fromRow - toRow) >= 0))) &&
                (( (2 >= (toCol - fromCol)) && ((toCol - fromCol) >= 0)) ||
                    ((2 >= (fromCol - toCol)) && ((fromCol - toCol) >= 0))));

    }
}


