package com.poker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TournamentLoggerTest {

    @Test
    public void testWriteAndReadLog() {
        TournamentLogger logger = new TournamentLogger();
        logger.writeLog("Test log entry");
        String content = logger.read();
        assertTrue(content.contains("Test log entry"));
    }
}
