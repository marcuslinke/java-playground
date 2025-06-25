package org.example;

import java.util.HashMap;
import java.util.Map;

public class PlayerStats {
    int wins, draws, losses;

    private final String description;

    public PlayerStats(String description) {
        assert (description != null) : "description is null";
        this.description = description.trim();
    }

    public String getDescription() {
        return description;
    }

    public Map<GameResult, Integer> asMap() {
        Map<GameResult, Integer> map = new HashMap<>();
        map.put(GameResult.WON, wins);
        map.put(GameResult.LOOSE, losses);
        map.put(GameResult.DRAW, draws);
        return map;
    }
}
