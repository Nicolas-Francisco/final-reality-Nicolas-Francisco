package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WhiteMageTest extends AbstractPlayerCharacterTest {

    private WhiteMage testWhiteMage;
    private IWeapon testStaff;

    @Test
    void waitTurnTest() {
        testWhiteMage = new WhiteMage(WHITEMAGE_NAME, turns, 10, 10, 10);
        testStaff = new Staff("test", 10, 10);
        testWhiteMage.equip(testStaff);
        Assertions.assertTrue(turns.isEmpty());
        testWhiteMage.waitTurn();
        try {
            // Thread.sleep is not accurate so this values may be changed to adjust the
            // acceptable error margin.
            // We're testing that the character waits approximately 1 second.
            Thread.sleep(900);
            Assertions.assertEquals(0, turns.size());
            Thread.sleep(200);
            Assertions.assertEquals(1, turns.size());
            Assertions.assertEquals(testWhiteMage, turns.peek());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void constructorTest() {
        var expectedWhiteMage = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 1);
        var differentWhiteMage1 = new WhiteMage("Logan", turns, 1, 1, 1);
        var differentWhiteMage2 = new WhiteMage(WHITEMAGE_NAME, turns, 5, 1, 1);
        var differentWhiteMage3 = new WhiteMage(WHITEMAGE_NAME, turns, 1, 5, 1);
        var differentWhiteMage4 = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 5);
        var expectedKnight = new Knight("Solaire", turns, 1, 1);

        assertEquals(expectedWhiteMage, expectedWhiteMage);
        assertEquals(expectedWhiteMage.hashCode(), expectedWhiteMage.hashCode());

        assertTrue(expectedWhiteMage.equals(expectedWhiteMage));
        assertFalse(expectedWhiteMage.equals(differentWhiteMage1));
        assertFalse(expectedWhiteMage.equals(differentWhiteMage2));
        assertFalse(expectedWhiteMage.equals(differentWhiteMage3));
        assertFalse(expectedWhiteMage.equals(differentWhiteMage4));
        assertFalse(expectedWhiteMage.equals(expectedKnight));
    }

    @Test
    void equipWeaponTest() {
        WhiteMage whitemage = new WhiteMage(WHITEMAGE_NAME, turns, 1, 1, 1);
        assertNull(whitemage.getEquippedWeapon());
        whitemage.equip(testStaff);
        assertEquals(testStaff, whitemage.getEquippedWeapon());
    }
}