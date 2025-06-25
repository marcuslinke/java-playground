package org.example;

import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class PlayerStatsFormatter {

    public String format(PlayerStats playerStats) {
        assert playerStats != null: "playerStats is null";

        List<Entry<GameResult, Integer>> sortedEntries = getSortedEntries(playerStats);

        StringBuilder sb = new StringBuilder();

        sb.append(playerStats.getDescription() + " stats (sorted by frequency):\n");
        for (Entry<GameResult, Integer> entry : sortedEntries) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        return sb.toString();
    }

    private static List<Entry<GameResult, Integer>> getSortedEntries(PlayerStats playerStats) {
        Map<GameResult, Integer> map = playerStats.asMap();
        List<Entry<GameResult, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        return sortedEntries;
    }
}


