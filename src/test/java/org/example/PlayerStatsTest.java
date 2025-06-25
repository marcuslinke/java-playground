package org.example;

import junit.framework.TestCase;

import java.util.Map;

public class PlayerStatsTest extends TestCase {

    public void testEmptyPlayerStatsAsMap() {
        PlayerStats stats = new PlayerStats("TestPlayer");
        Map<GameResult, Integer> map = stats.asMap();

        assertEquals(3, map.size());
        assertEquals(Integer.valueOf(0), map.get(GameResult.WON));
        assertEquals(Integer.valueOf(0), map.get(GameResult.LOOSE));
        assertEquals(Integer.valueOf(0), map.get(GameResult.DRAW));
    }

    public void testPlayerStatsWithResultsAsMap() {
        PlayerStats stats = new PlayerStats("TestPlayer");
        stats.wins = 5;
        stats.losses = 3;
        stats.draws = 2;

        Map<GameResult, Integer> map = stats.asMap();

        assertEquals(3, map.size());
        assertEquals(Integer.valueOf(5), map.get(GameResult.WON));
        assertEquals(Integer.valueOf(3), map.get(GameResult.LOOSE));
        assertEquals(Integer.valueOf(2), map.get(GameResult.DRAW));

    }
}