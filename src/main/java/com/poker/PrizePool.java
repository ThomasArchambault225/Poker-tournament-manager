package com.poker;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents the prize pool of the tournament with robust error handling.
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

        if (buyIn <= 0) {
            System.out.println("Invalid buy-in amount.");
            return;
        }

        // Filter out the players with null names
        List<Player> validPlayers = players.stream()
                .filter(p -> p.getName() != null)
                .collect(Collectors.toList());

        int totalPrizePool = validPlayers.size() * buyIn;
        System.out.println("Total prize pool: $" + totalPrizePool);

        List<Player> topPlayers = validPlayers.stream()
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

    /**
     * TournamentLogger with better error handling
     */
    public static class TournamentLogger {
        private final String logFile = "tournament_log.txt";

        public void writeLog(String message) {
            if (message == null || message.isEmpty()) {
                System.out.println("Cannot write null or empty message to log.");
                return;
            }
            try (FileWriter fileWriter = new FileWriter(logFile, true);
                 BufferedWriter bufferedWriterw = new BufferedWriter(fileWriter);
                 PrintWriter out = new PrintWriter(bufferedWriterw)) {
                out.println(message);
            } catch (IOException e) {
                System.err.println("Error writing log: " + e.getMessage());
            }
        }

        public String read() {
            StringBuilder stringBuilder = new StringBuilder();
            File file = new File(logFile);
            if (!file.exists()) {
                System.out.println("Log file does not exist yet.");
                return "";
            }
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
            } catch (IOException e) {
                System.err.println("Error reading log: " + e.getMessage());
            }
            return stringBuilder.toString();
        }
    }
}
