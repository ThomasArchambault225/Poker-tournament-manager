package com.poker;

import java.io.*;

/**
 * Logs tournament data to a file.
 */
public class TournamentLogger {
    private final String logFile = "tournament_log.txt";

    public void writeLog(String message) {
        try (FileWriter fw = new FileWriter(logFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(message);
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }

    public String read() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading log: " + e.getMessage());
        }
        return sb.toString();
    }
}
