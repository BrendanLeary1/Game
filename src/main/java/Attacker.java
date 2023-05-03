/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Attacker is an abstract class that extends Unit. It allows us
 * to condense a bit of common code any troops that can attack.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */
public abstract class Attacker extends Unit {
    private int numAttacks;

    public Attacker(char symbol, String name, double health, double healthModifier, double damage,
                    double damageModifier, int luck, int xCor, int yCor, int movement,
                    int movementModifier, String teamColor, int numAttacks){
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor);
        this.numAttacks = numAttacks;
    }

    public int getNumAttacks(){return this.numAttacks;}
    public void setNumAttacks(int newNumAttacks){this.numAttacks = newNumAttacks;}
    public boolean validAttackPath(int rowAttacker, int colAttacker, int rowDefender, int colDefender){
        return true;//TK Later
    }

}
