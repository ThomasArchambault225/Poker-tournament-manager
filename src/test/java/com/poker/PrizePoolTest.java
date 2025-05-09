package com.poker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PrizePoolTest {

    @Test
    public void testCalculatePrizes_TieredDistribution() {
        Player p1 = new Player("Alice", 1);
        Player p2 = new Player("Bob", 2);
        Player p3 = new Player("Charlie", 3);
        Player p4 = new Player("Diana", 4);

        setChips(p1, 1500);
        setChips(p2, 1200);
        setChips(p3, 900);
        setChips(p4, 500);

        List<Player> players = Arrays.asList(p1, p2, p3, p4);

        PrizePool prizePool = new PrizePool();
        prizePool.calculatePrizes(players, 100);

        Map<Player, Integer> distribution = prizePool.getPrizeDistribution();

        assertEquals(200, distribution.get(p1));
        assertEquals(120, distribution.get(p2));
        assertEquals(80, distribution.get(p3));
        assertNull(distribution.get(p4));
    }

    // Helper to set chips directly
    private void setChips(Player player, int chips) {
        try {
            java.lang.reflect.Field chipsField = Player.class.getDeclaredField("chips");
            chipsField.setAccessible(true);
            chipsField.set(player, chips);
        } catch (Exception e) {
            fail("Failed to set chips via reflection");
        }
    }
}
