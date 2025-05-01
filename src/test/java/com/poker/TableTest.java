package com.poker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class TableTest {

    @Test
    public void testTablePlayHand() {
        Player p1 = new Player("Alice", 1);
        Player p2 = new Player("Bob", 2);
        Table table = new Table(Arrays.asList(p1, p2));
        table.playHand();
    }
}
