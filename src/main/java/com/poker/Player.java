package com.poker;

/**
 * Represents a Player in the poker tournament
 */
public class Player extends User implements Playable, Comparable<Player> {
    private int chips;
    private String status;

    /**
     * Constructs a Player with a name and ID
     * @param name the player's name
     * @param id the player's ID
     */
    public Player(String name, int id) {
        //TODO: implement
    }

    /**
     * Simulates playing a hand
     */
    @Override
    public void playHand() {
        //TODO: implement
    }

    /**
     * Compares two players by chip count
     * @param other another Player
     * @return comparison result
     */
    @Override
    public int compareTo(Player other) {
        //TODO: implement
        return 0;
    }
}
