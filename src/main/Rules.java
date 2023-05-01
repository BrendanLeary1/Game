public class Rules {
    public static boolean checkValidAction(Game game, int firstRow, int firstCol, int secRow, int secCol, char action)  {
         /** Checks if the action char is not one of the valid options (M,S,R,A)
          *  If not, return false
          *  Otherwise, assesses based on the valid action option
          **/
         if(action != 'M' && action != 'S' && action != 'R' && action != 'A') {
             return false;
         } else {
             // Move
             if(action == 'M') {
             }
         }
    }
}
