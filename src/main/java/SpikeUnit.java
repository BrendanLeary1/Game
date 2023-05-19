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



}
