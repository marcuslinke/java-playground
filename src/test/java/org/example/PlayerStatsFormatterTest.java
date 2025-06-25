package org.example;

public class PlayerStatsFormatterTest extends junit.framework.TestCase {
    private PlayerStatsFormatter formatter;

    protected void setUp() {
        formatter = new PlayerStatsFormatter();
    }

    public void testFormat() {
        PlayerStats stats = new PlayerStats("Test Player");
        stats.wins = 10;
        stats.losses = 5;
        stats.draws = 3;

        String expected1 = "Test Player stats (sorted by frequency):\n" +
                "WON: 10\n" +
                "LOOSE: 5\n" +
                "DRAW: 3\n";

        assertEquals(expected1, formatter.format(stats));

        stats.wins = 3;
        stats.losses = 10;
        stats.draws = 5;

        String expected2 = "Test Player stats (sorted by frequency):\n" +
                "LOOSE: 10\n" +
                "DRAW: 5\n" +
                "WON: 3\n";

        assertEquals(expected2, formatter.format(stats));
    }

    public void testFormatNull() {
        try {
            formatter.format(null);
            fail("Expected AssertionError");
        } catch (AssertionError e) {
            assertEquals("playerStats is null", e.getMessage());
        }
    }
}