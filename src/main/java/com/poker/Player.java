package com.poker;

/**
 * Represents a Player in the poker tournament
 */
public class Player extends User implements Playable, Comparable<Player> {
    private int chips;
    private String status;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.chips = 1000; // default starting chips
        this.status = "Active";
    }

    @Override
    public void playHand() {
        int bet = (int)(Math.random() * 200); // Simulate a random bet
        chips -= bet;
        if (chips <= 0) {
            chips = 0;
            status = "Eliminated";
        }
        System.out.println(name + " played a hand and now has " + chips + " chips.");
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.chips, this.chips);
    }

    public int getChips() {
        return chips;
    }

    public String getStatus() {
        return status;
    }
}
