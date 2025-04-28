package com.poker;

public class Player extends User implements Playable, Comparable<Player> {
    private int chips;
    private String status;

    public void playHand() {}

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.chips, this.chips);
    }
}