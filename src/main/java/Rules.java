public class Rules {
    public static boolean checkValidAction(Game game, int fromRow, int fromCol, int toRow, int toCol, char action)  {
         // Checks if the action char is not one of the valid options (M,S,R,A)
         if(action != 'M' && action != 'S' && action != 'R' && action != 'A') {
             return false;
         } else {
             // Assesses whether the From Unit is in bounds and contains a unit
             private GameBoard board = game.getGameBoard();
             private BoardSquare[][] squares = board.getSquares();
             private Team currentTeam = game.getCurrentPlayer().getPlayersTeam();
             private Team opposingTeam = game.getOpponentPlayer().getPlayersTeam();
             if(board.inBounds(fromRow, fromCol) && !(squares[fromRow][fromCol].isEmptySpace())) {
                 // Checks whether the From Unit is from the current player's team
                 private Unit fromUnit = squares[fromRow][fromCol].getUnit();
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
                         if(squares[toRow][toCol].isEmptySpace()) {
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
                            private Unit toUnit =  squares[toRow][toCol].getUnit();
                            // Checks whether the To Unit is of the opposing team
                            if(opposingTeam.getTeamColor().equals(toUnit.getTeamColor())) {
                                // ***** Recruit
                                if(action == 'R') {
                                    // Checks whether the from unit can recruit
                                    if(fromUnit instanceof BartSimpsonUnit) {
                                        // Checks whether the from unit has a valid recruit path
                                        if(fromUnit.validRecruitPath(fromRow, fromCol, toRow, toCol)) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                // ***** Attack
                                } else {
                                    // Checks whether the from unit can attack
                                    if(fromUnit instanceof TomJerryUnit) {
                                        // Checks whether the from unit has a valid attack path
                                        if(fromUnit.validAttackPath(fromRow, fromCol, toRow, toCol)) {
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
