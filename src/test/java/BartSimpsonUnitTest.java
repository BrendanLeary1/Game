import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BartSimpsonUnitTest {
    @Test
    public void testingBartSimpsonNoParameterConstructor() {
        System.out.println("Creating Bart Simpson with 0 parameter constructor");
        BartSimpsonUnit bart = new BartSimpsonUnit();
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Symbol");
        assertEquals('B', bart.getSymbol());
        System.out.println("-- Testing Name");
        assertEquals("Bart Simpson", bart.getName());
        System.out.println("-- Testing Health");
        assertEquals(100.0, bart.getHealth());
        System.out.println("-- Testing Number Times Spawned");
        assertEquals(0, bart.getNumTimesSpawned());
        System.out.println("-- Testing Distract");
        assertTrue(bart.canDistract());
        System.out.println("-- Testing Recruit");
        assertTrue(bart.canRecruit());
    }

    @Test
    public void testingBartSimpsonParameterConstructor() {
        System.out.println("Creating Bart Simpson with 14 parameter constructors");
        BartSimpsonUnit bart1 = new BartSimpsonUnit('B', "Bart Simpson", 100.0,
                5.0, 15.0, 1.0, 3, 3, 2, 2,
                1, 0, true, true, "", 0);
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Health Modifier");
        assertEquals(5.0, bart1.getHealthModifier(), 0.0001);
        System.out.println("-- Testing Damage");
        assertEquals(15.0, bart1.getDamage(), 0.0001);
        System.out.println("-- Testing Damage Modifier");
        assertEquals(1.0, bart1.getDamageModifier(), 0.0001);
        System.out.println("-- Testing Luck");
        assertEquals(3, bart1.getLuck());
        System.out.println("-- Testing X Coordinate");
        assertEquals(3, bart1.getxCor());
        System.out.println("-- Testing Y Coordinate");
        assertEquals(2, bart1.getyCor());
        System.out.println("-- Testing Movement");
        assertEquals(2, bart1.getMovement());
        System.out.println("-- Testing Movement Modifier");
        assertEquals(1, bart1.getMovementModifier());
        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();
        System.out.println("-- Testing Symbol");
        bart1.setSymbol('b');
        assertEquals('b', bart1.getSymbol());
        System.out.println("-- Testing Damage Modifier");
        bart1.setDamageModifier(2.0);
        assertEquals(2.0, bart1.getDamageModifier(), 0.0001);
        System.out.println("-- Testing Recruit");
        bart1.setRecruit(false);
        assertFalse(bart1.canRecruit());
        System.out.println("-- Testing Distract");
        assertTrue(bart1.canDistract());
        bart1.setRecruit(false);
        assertFalse(bart1.canRecruit());

    }
    @Test
    public void test_spawn() {
        System.out.println("Testing spawn");
        BartSimpsonUnit oldBart = new BartSimpsonUnit();
        assertTrue(oldBart.canSpawn());
        BartSimpsonUnit newBart = oldBart.spawn();
        assertEquals(1, oldBart.getNumTimesSpawned());
        assertFalse(oldBart.canSpawn());
    }

}