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
import java.util.Collections;

public class Controller {
    private Game game;
    private TextView view;

    private GameEventsLinkedList gameList;

    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();


        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");


        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");

        // Added SpikeUnit to each player's team
        SpikeUnit s = new SpikeUnit();
        s.setTeamColor("Blu");

        // Added ScoobyDooUnit to each player's team
        ScoobyDooUnit sd = new ScoobyDooUnit();
        sd.setTeamColor("Blu");


        piecesTeamA.add(bs);
        piecesTeamA.add(tj);
        piecesTeamA.add(s);
        piecesTeamA.add(sd);


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

        SpikeUnit s2 = new SpikeUnit();
        s2.setTeamColor("Red");

        ScoobyDooUnit sd2 = new ScoobyDooUnit();
        sd2.setTeamColor("Red");


        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);
        piecesTeamB.add(s2);
        piecesTeamB.add(sd2);


        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);


        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    //0 param
    public Controller(){
        this.game = setUpGameModel();
        this.view = new TextView();
        gameList = new GameEventsLinkedList();
        view.updateView(game);
    }

    //instance method carryOutAction
    public void carryOutAction(int fromRow, int fromCol, int toRow, int toCol, char actionType){
        if(actionType == 'M'){
            ActionMove action = new ActionMove(game, fromRow, fromCol, toRow, toCol);
            action.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "move", action.toString());
            gameList.push(new GameEventNode(gameEvent));

            GameEventNode eventNode = new GameEventNode(gameEvent);
            gameList.push(eventNode);
        }
        if(actionType == 'S'){
            ActionSpawn action = new ActionSpawn(game, fromRow, fromCol, toRow, toCol);
            action.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "spawn", action.toString());
            gameList.push(new GameEventNode(gameEvent));

            GameEventNode eventNode = new GameEventNode(gameEvent);
            gameList.push(eventNode);
        }
        if(actionType == 'R'){
            ActionRecruit action = new ActionRecruit(game, fromRow, fromCol, toRow, toCol);
            action.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "recruit", action.toString());
            gameList.push(new GameEventNode(gameEvent));

            GameEventNode eventNode = new GameEventNode(gameEvent);
            gameList.push(eventNode);
        }
        if(actionType == 'A'){
            ActionAttack action = new ActionAttack(game, fromRow, fromCol, toRow, toCol);
            action.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "attack", action.toString());
            gameList.push(new GameEventNode(gameEvent));

            GameEventNode eventNode = new GameEventNode(gameEvent);
            gameList.push(eventNode);
        }
        // New Action Modification
        if(actionType == 'B'){
            ActionBark action = new ActionBark(game, fromRow, fromCol, toRow, toCol);
            action.performAction();
            GameEvent gameEvent = new GameEvent(game.getCurrentPlayer().getPlayerNumber(), "bark", action.toString());
            gameList.push(new GameEventNode(gameEvent));

            GameEventNode eventNode = new GameEventNode(gameEvent);
            gameList.push(eventNode);
        }
        //problem 6


    }

    //public method names playyGame

    public void playGame() {
        while (! game.isGameEnded()) {
            view.getNextPlayersAction(game);
            boolean isValidAction = false;
            while (! isValidAction) {
                if (Rules.checkValidAction(game, view.getFromRow(), view.getFromCol(), view.getToRow(), view.getToCol(), view.getAction())) {
                    carryOutAction(view.getFromRow(), view.getFromCol(), view.getToRow(), view.getToCol(), view.getAction());
                    isValidAction = true;
                }
                else {
                    view.getNextPlayersAction(game);
                }
            }

            //print Game objecct
            // game.changeTurn();
            // System.out.println(game.toString());
            //if game is not ended Repeat above

        }

        GameEventNode lastNode = gameList.pop();
        if (lastNode != null) {
            System.out.println("Winning Move: " + lastNode.getGameState().getEventDetails());
        }

    ArrayList<GameEventsLinkedList> eventLists = new ArrayList<GameEventsLinkedList>();
    String[] eventTypes = { "move", "spawn", "recruit", "attack", "bark" }; // Assuming these are the event types

    view.printEndOfGameMessage(game);
    for (String eventType : eventTypes) {
        GameEventsLinkedList eventTypeList = gameList.pop(eventType);
        eventLists.add(eventTypeList);
    }

    // The issue we had here was getting it to show a size of 0 for any eventTypes that happened 0 times, which can
    //be seen in the video demonstrating the win condition.

    Collections.sort(eventLists);

    for (GameEventsLinkedList eventList : eventLists) {
        System.out.println("EventType: " + eventList.getHead().getGameState().getEventType() +
                    ", Size: " + eventList.getSize());
        }

    }

        //print message of player who won
        //TK add main

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }

}
