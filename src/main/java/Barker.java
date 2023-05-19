/**
 * // New Unit Modifications
 * <h1>Final Project</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Barker is an abstract class that extends Unit. It allows for
 * units to use its functionality and override validBarkPath as
 * its subclasses deem necessary.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-18
 */
public abstract class Barker extends Unit {
    // Please refer to the docstring of the ActionBark class for more information on barkRange
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