public class ScoobyDooUnit extends Barker {
    private boolean canSpeak;

    public ScoobyDooUnit(char symbol, String name, double health, double healthModifier, double damage,
                         double damageModifier, int luck, int xCor, int yCor, int movement,
                         int movementModifier, String teamColor, int barkRange, boolean canSpeak) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor, barkRange);
        this.canSpeak = canSpeak;
    }
    public ScoobyDooUnit spawn() {
        ScoobyDooUnit scooby = new ScoobyDooUnit('S', "Scooby", 100.0,
                5.0, 25.0, 10.0, 0, 1, 1, 1,
                1, "Blue", 1, true);
        return scooby;
    }

    @Override
    public boolean validMovePath(int fromRow, int fromCol, int toRow, int toCol) {
        return true;
    }

    @Override
    public boolean validSpawnPath(int fromRow, int fromCol, int toRow, int toCol) {
        return true;
    }

    public boolean canSpawn(){ return true; }

    public char barkDirection(int fromRow, int fromCol, int toRow, int toCol) {
        if(fromRow == toRow) {
            if(fromCol > toCol) {
                return 'L';
            } else if (fromCol < toCol) {
                return 'R';
            }
        } else if (fromCol == toCol) {
            if(fromRow > toRow) {
                return 'U';
            } else if (fromRow < toRow) {
                return 'D';
            }
        }
        // In the case the barked at piece is not in a cardinal direction,
        // The method returns '/' for the diagonal direction
        return '/';
    }

    public boolean validBarkPath(int fromRow, int fromCol, int toRow, int toCol) {
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
