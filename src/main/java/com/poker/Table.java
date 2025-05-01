package com.poker;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a poker table.
 */
public class Table implements Playable {
    private List<Player> players;

    public Table(List<Player> players) {
        this.players = players;
    }

    @Override
    public void playHand() {
        System.out.println("=== Playing a hand at the table ===");
        players.forEach(Player::playHand);

        System.out.println("\nPlayers sorted by chips:");
        players.stream()
                .sorted()
                .forEach(p -> System.out.println(p.getName() + ": " + p.getChips()));

        System.out.println("\nActive players:");
        players.stream()
                .filter(p -> "Active".equalsIgnoreCase(p.getStatus()))
                .forEach(p -> System.out.println(p.getName() + ": " + p.getStatus()));
    }
}
