import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomJerryUnitTest {
    @Test
    public void testingTomJerryNoParameterConstructor() {
        System.out.println("Creating Tom & Jerry with 0 parameter constructor");
        TomJerryUnit tj = new TomJerryUnit();
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Homing Rocket");
        assertTrue(tj.canHomingRocket());
        System.out.println("-- Testing Offer Cheese");
        assertTrue(tj.canOfferCheese());
        System.out.println("-- Testing Hiding");
        assertFalse(tj.isHiding());
        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();
        System.out.println("-- Testing Homing Rocket");
        tj.setHomingRocket(false);
        assertFalse(tj.canHomingRocket());
        System.out.println("-- Testing Offer Cheese");
        tj.setOfferCheese(false);
        assertFalse(tj.canOfferCheese());
        System.out.println("-- Testing Hiding");
        tj.setHiding(true);
        assertTrue(tj.isHiding());
        System.out.println();
        System.out.println("-- Testing Instance Methods 2");
        System.out.println();
        System.out.println("-- Testing Deal Damage");
        assertEquals(25.0, tj.dealDamage(), 0.0001);
        tj.setHomingRocket(true);
        assertEquals(35.0, tj.dealDamage(), 0.0001);
        System.out.println("-- Testing Take Damage");
        tj.takeDamage(25.0);
        assertEquals(100.0, tj.getHealth(), 0.0001);
        tj.setHiding(false);
        tj.takeDamage(25.0);
        assertEquals(75.0, tj.getHealth(), 0.0001);
    }
    @Test
    public void testingTomJerryParameterConstructor() {
        System.out.println("Creating Tom & Jerry with 14 parameter constructor");
        TomJerryUnit tj = new TomJerryUnit('T', "Tom And Jerry", 100.0, 10.0,
                25.0, 5.0, 1, 1, 1, 0, 1,
                true, true, false, "");
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Homing Rocket");
        assertTrue(tj.canHomingRocket());
        System.out.println("-- Testing Offer Cheese");
        assertTrue(tj.canOfferCheese());
        System.out.println("-- Testing Hiding");
        assertFalse(tj.isHiding());
        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();
        System.out.println("-- Testing Homing Rocket");
        tj.setHomingRocket(false);
        assertFalse(tj.canHomingRocket());
        System.out.println("-- Testing Offer Cheese");
        tj.setOfferCheese(false);
        assertFalse(tj.canOfferCheese());
        System.out.println("-- Testing Hiding");
        tj.setHiding(true);
        assertTrue(tj.isHiding());
        System.out.println();
        System.out.println("-- Testing Instance Methods 2");
        System.out.println();
        System.out.println("-- Testing Deal Damage");
        assertEquals(30.0, tj.dealDamage(), 0.0001);
        tj.setHomingRocket(true);
        assertEquals(40.0, tj.dealDamage(), 0.0001);
        System.out.println("-- Testing Take Damage");
        tj.takeDamage(25.0);
        assertEquals(100.0, tj.getHealth(), 0.0001);
        tj.setHiding(false);
        tj.takeDamage(25.0);
        assertEquals(75.0, tj.getHealth(), 0.0001);
    }

}