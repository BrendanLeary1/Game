/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Rules is a class that sets up the basic turn mechanics for the main game.
 * We can check if the Unit trying to perform an action is performing a valid
 * action.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */

public class Rules {
    public static boolean checkValidAction(Game game, int fromRow, int fromCol, int toRow, int toCol, char action)  {
        // Checks if the action char is not one of the valid options (M,S,R,A,B)
         if (!( (action == 'M' || action == 'S') || (action == 'R' || action == 'A') || action == 'B') ) {
             return false;
         } else {
             // Assesses whether the From Unit is in bounds and contains a unit
             GameBoard board = game.getGameBoard();
             BoardSquare[][] squares = board.getSquares();
             Team currentTeam = game.getCurrentPlayer().getPlayersTeam();
             Team opposingTeam = game.getOpponentPlayer().getPlayersTeam();
             if(board.inBounds(fromRow, fromCol) && !(squares[fromRow][fromCol].isEmptySpace())) {
                 // Checks whether the From Unit is from the current player's team
                 Unit fromUnit = squares[fromRow][fromCol].getUnit();
                 if(currentTeam.getTeamColor().equals(fromUnit.getTeamColor())) {
                     // ***** Move
                     if (action == 'M') {
                         // Checks whether the To Unit is empty
                         if(squares[toRow][toCol].isEmptySpace()) {
                             // Checks whether the move path is valid
                             if(fromUnit.validMovePath(fromRow, fromCol, toRow, toCol)) {
                                 return true;
                             } else {
                                 return false;
                             }
                         } else {
                             return false;
                         }
                     // ***** Spawn
                     } else if (action == 'S') {
                         // Checks whether the To Unit is empty
                         if((squares[toRow][toCol].isEmptySpace() && squares[toRow][toCol].getUnit().canSpawn())) {
                             // Checks whether the spawn path is valid
                             if(fromUnit.validSpawnPath(fromRow, fromCol, toRow, toCol)) {
                                 return true;
                             } else {
                                 return false;
                             }
                         } else {
                             return false;
                         }
                     } else {
                         // Checks whether the To Unit is not empty
                         if(!squares[toRow][toCol].isEmptySpace()) {
                            Unit toUnit =  squares[toRow][toCol].getUnit();
                            // Checks whether the To Unit is of the opposing team
                            if(opposingTeam.getTeamColor().equals(toUnit.getTeamColor())) {
                                // ***** Recruit
                                if(action == 'R') {
                                    // Checks whether the from unit can recruit
                                    if(fromUnit instanceof Recruiter) {
                                        // Checks whether the from unit has a valid recruit path
                                        // must cast from unit to Recruiter
                                        if(((Recruiter) fromUnit).validRecruitPath(fromRow, fromCol, toRow, toCol)) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                // ***** Attack
                                } else if (action == 'A'){
                                    // Checks whether the from unit can attack
                                    if(fromUnit instanceof Attacker) {
                                        // Checks whether the from unit has a valid attack path
                                        // must cast from unit to Attacker
                                        if(((Attacker) fromUnit).validAttackPath(fromRow, fromCol, toRow, toCol)) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                // ***** Bark
                                } else {
                                    // Checks whether the from unit can bark
                                    if(fromUnit instanceof Barker) {
                                        // Checks whether the from unit has a valid bark path
                                        // must cast from unit to Barker
                                        if (((Barker) fromUnit).validBarkPath(fromRow, fromCol, toRow, toCol)) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                }
                            } else {
                                return false;
                            }
                         } else {
                             return false;
                         }
                     }
                 } else {
                     return false;
                 }
             } else {
                 return false;
             }
         }
    }
}
