/**
 * // New Unit Modification
 * <h1>Final Project</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The ScoobyDooUnit class, which extends Barker, which then
 * extends Unit, is a Unit with the field canSpeak, a constructor,
 * overridden methods from Unit, and two instance methods:
 * barkDirection and validBarkPath.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-18
 */
public class ScoobyDooUnit extends Barker {
    private boolean canSpeak;

    public ScoobyDooUnit(char symbol, String name, double health, double healthModifier, double damage,
                         double damageModifier, int luck, int xCor, int yCor, int movement,
                         int movementModifier, String teamColor, int barkRange, boolean canSpeak) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor, barkRange);
        this.canSpeak = canSpeak;
    }

    public ScoobyDooUnit() {
        this('D', "Scooby Doo", 100.0, 0.0, 25.0, 0.0,
                0, 5, 5, 1, 0, "none", 8, true);
    }

    public ScoobyDooUnit spawn() {
        ScoobyDooUnit scooby = new ScoobyDooUnit('S', "Scooby", 100.0,
                5.0, 25.0, 10.0, 0, 1, 1, 1,
                1, "Blue", 1, true);
        return scooby;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        if ((fromRow == toRow) && (toCol == fromCol)) {
            return false;
        }
        return (((fromRow == toRow) && (((2 >= fromCol - toCol) && (fromCol - toCol >= 0)) ||
                ((2 >= toCol - fromCol) && (toCol - fromCol >= 0)))) ||
                ((fromCol == toCol) && (((2 >= fromRow - toRow) && (fromRow - toRow >= 0)) ||
                        ((2 >= toRow - fromRow) && (toRow - fromRow >= 0)))));
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        if ((fromRow == toRow) && (toCol == fromCol)) {
            return false;
        }
        return ((((1 >= (toRow - fromRow)) && ((toRow - fromRow) >= 0)) ||
                ((1 >= (fromRow - toRow)) && ((fromRow - toRow) >= 0))) &&
                (( (1 >= (toCol - fromCol)) && ((toCol - fromCol) >= 0)) ||
                ((1 >= (fromCol - toCol)) && ((fromCol - toCol) >= 0))));
    }

    public boolean canSpawn(){ return true; }

    // barkDirection returns a char that represents the direction of the barked at
    // Unit relative to the position of the barking unit
    public char barkDirection(int fromRow, int fromCol, int toRow, int toCol) {
        if(fromRow == toRow) {
            if(fromCol > toCol) {
                return 'L';
            } else { // toCol > fromCol
                return 'R';
            }
        } else if (fromCol == toCol) {
            if(fromRow > toRow) {
                return 'U';
            } else { // toRow > fromRow
                return 'D';
            }
        }
        // In the case the barked at piece is not in a cardinal direction,
        // The method returns '/' for the diagonal direction
        return '/';
    }

    // validBarkPath returns a boolean that represents whether the unit at [fromRow][fromCol]
    // can bark at its target, based on if it is in its bark range and in a cardinal direction
    public boolean validBarkPath(int fromRow, int fromCol, int toRow, int toCol) {
        if ((fromRow == toRow) && (toCol == fromCol)) {
            return false;
        }
        // Get direction of the bark
        char direction = barkDirection(fromRow,fromCol,toRow,toCol);
        if(direction == '/') {
            return false;
        } else if (direction == 'L' && toCol >= fromCol - getBarkRange()) {
            return true;
        } else if (direction == 'R' && toCol <= fromCol + getBarkRange()) {
            return true;
        } else if (direction == 'U' && toRow >= fromRow - getBarkRange()) {
            return true;
        } else if (direction == 'D' && toRow <= fromRow + getBarkRange()) {
            return true;
        } return false;
    }



}
