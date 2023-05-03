/**
 * <h1>Lab7</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Controller is a class that lets us finally play this game. While it doesn't really
 * do anything meaningful yet, we can finally set up a board, perform actions, and
 * run the game.
 *
 * @author Brendan Leary, Jacob Whitman, Meaghan Roth
 *
 * @since 2023-05-03
 */

import java.util.ArrayList;

public class Controller {
    private Game game;
    private TextView view;

    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();


        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");


        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");


        piecesTeamA.add(bs);
        piecesTeamA.add(tj);


        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        Player playerOne = new Player(1, true, teamA);


        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();


        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");


        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");


        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);


        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);


        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    //0 param
    public Controller(){
        game = setUpGameModel();
        view = new TextView();
        view.updateView(game);
    }

    //instance method carryOutAction
    public void carryOutAction(int fromRow, int fromCol, int toRow, int toCol, char actionType){
        if(actionType == 'M'){
            new ActionMove(game, fromRow, fromCol, toRow, toCol).performAction();
        }
        if(actionType == 'S'){
            new ActionSpawn(game, fromRow, fromCol, toRow, toCol).performAction();
        }
        if(actionType == 'R'){
            new ActionRecruit(game, fromRow, fromCol, toRow, toCol).performAction();
        }
        if(actionType == 'A'){
            new ActionAttack(game, fromRow, fromCol, toRow, toCol).performAction();
        }
    }

    //public method names playyGame

    public void playGame() {
        while (! game.isGameEnded()) {
            view.getNextPlayersAction(game);
            while (!Rules.checkValidAction(game, view.getFromRow(), view.getFromCol(), view.getToRow(), view.getToCol(), view.getAction())) {
                view.getNextPlayersAction(game);
            }
            //calls carryOutAction
            carryOutAction(view.getFromRow(), view.getFromCol(), view.getToRow(), view.getToCol(), view.getAction());
            //print Game objecct
            System.out.println(game);
            //if game is not ended Repeat above
        }

        //print message of player who won
        game.getWinner();
        //TK add main
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }

}
