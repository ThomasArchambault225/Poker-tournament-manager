package com.poker;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents the prize pool of the tournament.
 */
public class PrizePool extends TournamentComponent {

    private final Map<Player, Integer> prizeDistribution = new HashMap<>();

    /**
     * Calculates prizes for the top 3 players based on chip counts.
     * @param players List of players
     * @param buyIn Buy-in amount per player
     */
    public void calculatePrizes(List<Player> players, int buyIn) {
        if (players == null || players.isEmpty()) {
            System.out.println("No players to calculate prizes.");
            return;
        }

        int totalPrizePool = players.size() * buyIn;
        System.out.println("Total prize pool: $" + totalPrizePool);

        List<Player> topPlayers = players.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        int firstPrize = (int) (totalPrizePool * 0.5);
        int secondPrize = (int) (totalPrizePool * 0.3);
        int thirdPrize = (int) (totalPrizePool * 0.2);

        if (topPlayers.size() >= 1) {
            prizeDistribution.put(topPlayers.get(0), firstPrize);
            System.out.println("1st: " + topPlayers.get(0).getName() + " wins $" + firstPrize);
        }
        if (topPlayers.size() >= 2) {
            prizeDistribution.put(topPlayers.get(1), secondPrize);
            System.out.println("2nd: " + topPlayers.get(1).getName() + " wins $" + secondPrize);
        }
        if (topPlayers.size() >= 3) {
            prizeDistribution.put(topPlayers.get(2), thirdPrize);
            System.out.println("3rd: " + topPlayers.get(2).getName() + " wins $" + thirdPrize);
        }
    }

    /**
     * Gets the prize distribution map.
     * @return Map of Player to prize amount
     */
    public Map<Player, Integer> getPrizeDistribution() {
        return prizeDistribution;
    }
}
