import java.util.Scanner;

public class TextView {
    private int fromRow;
    private int fromCol;
    private int toRow;
    private int toCol;
    private char action;

    // No constructor

    // Getters
    public int getFromRow() {
        return fromRow;
    }

    public int getFromCol() {
        return fromCol;
    }

    public int getToRow() {
        return toRow;
    }

    public int getToCol() {
        return toCol;
    }

    public char getAction() {
        return action;
    }

    // My Lab 2 functions - Meaghan
    /**
     * The getUsersNextActionType method takes a Scanner
     * and uses it to take characters until one of them matches
     * "A", "M", "R", or "S" in any case and then returns that
     * character.
     * @param scnr - Scanner for user input
     * @return - The character "A", "M", "R", or "S"
     */
    public static char getUsersNextActionType (Scanner scnr) {
        boolean isIncorrectChar = true;
        char charValue = ' ';
        while (isIncorrectChar) {
            System.out.println("Please press one of the following:\n - \'A\' to Attack\n - \'M\' to Move\n - \'R\' to Recruit\n - \'S\' to Spawn");
            charValue = scnr.next().toUpperCase().charAt(0);
            if ((charValue == 'A') || (charValue == 'M') || (charValue == 'R') || (charValue == 'S')) {
                isIncorrectChar = false;
            }
        }
        return charValue;
    }

    /**
     * The getValidInt method takes a maximum and minimum and
     * a scanner object and returns the first value the user types
     * that is in the inclusive range of that maximum and minimum.
     * @param min - The range's minimum
     * @param max - The range's maximum
     * @param scnr - Scanner for user input
     * @return - Int, The first value the user inputs which is in min - max
     */
    public static int getValidInt (int min, int max, Scanner scnr) {
        boolean isNotInRange = true;
        int numValue = 0;
        while (isNotInRange) {
            System.out.println("Please enter an integer in the inclusive range " + min + " - " + max);
            boolean isDigit = scnr.hasNextInt();
            String incorrectValue = "";
            // If the user input is an int
            if (isDigit) {
                numValue = scnr.nextInt();
                // If it is in the range
                if (numValue >= min && numValue <= max) {
                    // End the loop
                    isNotInRange = false;
                    // If it is not in the range
                } else {
                    // Output that it is not in the range
                    System.out.println(numValue + " is not in the range " + min + " - " + max + "\n");
                }
            }
            // If it is not an int
            else {
                incorrectValue = scnr.next();
                // Output that it is not an int
                System.out.println(incorrectValue + " is not an integer\n");
            }
        }
        return numValue;
    }

    public void getNextPlayersAction(Game game) {
        Scanner scnr = new Scanner(System.in);
        char action = getUsersNextActionType(scnr);
        int numRows = game.getBoardSquares().length;
        int numCols = game.getBoardSquares()[0].length;
        System.out.println("Please enter your square's row index. ");
        this.fromRow = getValidInt(0, numRows, scnr);
        System.out.println("Please enter your square's column index. ");
        this.fromCol = getValidInt(0,numCols, scnr);
        String descript = "";
        if(action == 'M') {
            descript = "you will move to";
        } else if (action == 'S') {
            descript = "where you will spawn your piece";
        } else if (action == 'R') {
            descript = "you will recruit";
        } else if (action == 'A') {
            descript = "you will attack";
        }
        System.out.println("Please enter the row index of the square " + descript + ".");
        this.toRow = getValidInt(0, numRows, scnr);
        System.out.println("Please enter the column index of the square " + descript + ".");
        this.toCol = getValidInt(0, numCols, scnr);
    }
    public void updateView(Game game) {
        System.out.println(game);
    }

    public void printEndOfGameMessage(Game game) {
        if(game.isAWinner()) {
            int winningNum;
            if(game.getCurrentPlayer().getPlayersTeam().getTeamUnits().size() > 0) {
                winningNum = game.getCurrentPlayer().getPlayerNumber();
            } else {
                winningNum = game.getOpponentPlayer().getPlayerNumber();
            }
            System.out.println("Congratulations to player " + winningNum + " for winning the game.\nEnd of game.");
        }
    }
}
