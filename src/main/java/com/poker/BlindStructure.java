package com.poker;

/**
 * Represents the blind structure of the tournament
 */
public class BlindStructure extends TournamentComponent {
    private int smallBlind = 50;
    private int bigBlind = 100;

    public void incrementBlinds() {
        smallBlind += 25;
        bigBlind += 50;
        System.out.println("Blinds increased to: SB=" + smallBlind + ", BB=" + bigBlind);
    }
}
