import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class PlayerTest {
    @Test
    public void testingPlayerNoParameterConstructor() {
        System.out.println("Creating Player with 0 parameter constructor");
        ArrayList<Unit> playerTeam = new ArrayList<Unit>();
        Team team1 = new Team("", playerTeam);
        Player player1 = new Player();
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Player Number");
        assertEquals(0, player1.getPlayerNumber());
        System.out.println("-- Testing Turn");
        assertFalse(player1.isTurn());
        System.out.println("-- Testing Player Team");
        assertEquals("", player1.getPlayersTeam().getTeamColor());
        assertEquals(team1.toString(), player1.getPlayersTeam().toString());
        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();
        player1.setPlayerNumber(15);
        assertEquals(15, player1.getPlayerNumber());
        System.out.println("-- Testing Turn");
        player1.setTurn(true);
        assertTrue(player1.isTurn());
        System.out.println("-- Testing Player Team");
        ArrayList<Unit> otherTeam = new ArrayList<Unit>();
        otherTeam.add(new TomJerryUnit());
        Team newTeam = new Team("Red", otherTeam);
        player1.setPlayersTeam(newTeam);
        assertSame(newTeam, player1.getPlayersTeam());
    }

    @Test
    public void testingPlayerTwoParameterConstructor() {
        System.out.println("Creating Player with 2 parameter constructor");
        ArrayList<Unit> myTeam = new ArrayList<Unit>();
        myTeam.add(new TomJerryUnit());
        Team team2 = new Team("Blue", myTeam);
        Player player2 = new Player(1, team2);
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Player Number");
        assertEquals(1, player2.getPlayerNumber());
        System.out.println("-- Testing Turn");
        assertFalse(player2.isTurn());
        System.out.println("-- Testing Player Team");
        assertSame(team2, player2.getPlayersTeam());
        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();
        player2.setPlayerNumber(11);
        assertEquals(11, player2.getPlayerNumber());
        System.out.println("-- Testing Turn");
        player2.setTurn(true);
        assertTrue(player2.isTurn());
        System.out.println("-- Testing Unit");
        ArrayList<Unit> otherTeam = new ArrayList<Unit>();
        otherTeam.add(new BartSimpsonUnit());
        Team newTeam = new Team("Red", otherTeam);
        player2.setPlayersTeam(newTeam);
        assertSame(newTeam, player2.getPlayersTeam());
    }

    @Test
    public void testingPlayerThreeParameterConstructor() {
        System.out.println("Creating Player with 3 parameter constructor");
        ArrayList<Unit> thirdTeam = new ArrayList<Unit>();
        thirdTeam.add(new TomJerryUnit());
        thirdTeam.add(new BartSimpsonUnit());
        Team team3 = new Team("Blue", thirdTeam);
        Player player3 = new Player(2, true, team3);
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Player Number");
        assertEquals(2, player3.getPlayerNumber());
        System.out.println("-- Testing Turn");
        assertTrue(player3.isTurn());
        System.out.println("-- Testing Player Team");
        assertSame(team3, player3.getPlayersTeam());
        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();
        player3.setPlayerNumber(15);
        assertEquals(15, player3.getPlayerNumber());
        System.out.println("-- Testing Turn");
        player3.setTurn(false);
        assertFalse(player3.isTurn());
        System.out.println("-- Testing Unit");
        ArrayList<Unit> otherTeam3 = new ArrayList<Unit>();
        otherTeam3.add(new BartSimpsonUnit());
        otherTeam3.add(new TomJerryUnit());
        Team finalTeam = new Team("Orange", otherTeam3);
        player3.setPlayersTeam(finalTeam);
        assertSame(finalTeam, player3.getPlayersTeam());
    }

}