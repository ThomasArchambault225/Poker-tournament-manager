package com.poker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayHandReducesChips() {
        Player p = new Player("Alice", 1);
        int initialChips = p.getChips();
        p.playHand();
        assertTrue(p.getChips() <= initialChips);
    }

    @Test
    public void testPlayerEliminatedWhenNoChips() {
        Player p = new Player("Bob", 2);
        for (int i = 0; i < 10; i++) {
            p.playHand();
        }
        assertTrue("Eliminated".equalsIgnoreCase(p.getStatus()) || p.getChips() > 0);
    }
}
