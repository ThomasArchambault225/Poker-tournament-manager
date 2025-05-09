package com.poker;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Daniel Negreanu", 1);
        Player p2 = new Player("Phil Ivey", 2);
        Player p3 = new Player("Phil Hellmuth", 3);
        Player p4 = new Player("Fedor Holz", 4);

        List<Player> players = Arrays.asList(p1, p2, p3, p4);
        Table table = new Table(players);

        table.playHand();

        BlindStructure blinds = new BlindStructure();
        blinds.incrementBlinds();

        PrizePool.TournamentLogger logger = new PrizePool.TournamentLogger();
        logger.writeLog("A hand was played with " + players.size() + " players.");

        PrizePool prizePool = new PrizePool();
        prizePool.calculatePrizes(players, 100);

        System.out.println("\nFinal prize distribution:");
        prizePool.getPrizeDistribution().forEach((player, prize) ->
                System.out.println(player.getName() + " won $" + prize)
        );
    }
}
