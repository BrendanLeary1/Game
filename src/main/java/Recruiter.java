/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Recruiter is an abstract class that extends Unit. It allows us
 * to condense a bit of common code any troops that can recruit.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */

public abstract class Recruiter extends Unit {
    private int numRecruits;

    public Recruiter(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
                     int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecruits) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor);
        this.numRecruits = numRecruits;
    }

    public int getNumRecruits() {
        return this.numRecruits;
    }
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    public abstract boolean validRecruitPath(int rowRecruiter, int colRecruiter, int rowRecruited, int colRecruited);
}
