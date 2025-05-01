package com.poker;

import java.util.Comparator;

/**
 * Comparator for sorting players by name
 */
public class PlayerNameComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
