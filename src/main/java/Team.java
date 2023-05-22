import java.util.ArrayList;

/**
 * <h1>Lab5</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The Team class allows us to establish a team color and a list of units
 * on that team. There are the standard getters and setters, as well as the
 * ability to add or remove a unit from the team and an updated version of toString.
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 * @since 2023-04-05
 */
public class Team {
    private String teamColor;
    private ArrayList<Unit> teamUnits;

    public Team(String teamColor, ArrayList<Unit> teamUnits) {
        this.teamColor = teamColor;
        this.teamUnits = teamUnits;
    }
    public Team() {
        this.teamColor = "";
        this.teamUnits = new ArrayList<Unit>();
    }

    public String getTeamColor() {
        return this.teamColor;
    }
    public ArrayList<Unit> getTeamUnits() {
        return this.teamUnits;
    }

    // Added getNumAttackers to figure out who wins
    public int getNumAttackers() {
        int numAttackers = 0;
        for (Unit unit : this.teamUnits) {
            if (unit instanceof Attacker) {
                numAttackers += 1;
            }
        }
        return numAttackers;
    }

    public void removeUnitsFromTeam(Unit removedUnit) {
        this.teamUnits.remove(removedUnit);
    }
    public void addUnitsToTeam(Unit addedUnit) {
        this.teamUnits.add(addedUnit);
        addedUnit.teamColor = this.teamColor;
    }

    public void removeMostRecentAttacker() {
        Unit mostRecentAttacker = null;
        for (Unit unit : teamUnits) {
            if (unit instanceof Attacker) {
                if (mostRecentAttacker == null) {
                    mostRecentAttacker = unit;
                }
            }
        }

        if (mostRecentAttacker != null) {
            teamUnits.remove(mostRecentAttacker);
        }
    }

    @Override
    public String toString() {
        String units = "";
        for (Unit aUnit : teamUnits) {
            units += aUnit.toString() + " ";
        }
        return "Team " + this.teamColor + " Units :" + "\n" + units;
    }
}
