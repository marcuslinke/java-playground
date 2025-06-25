package org.example;

public class PlayerStatsConsolePrinter implements PlayerStatsPrinter {

    private final PlayerStatsFormatter playerStatsFormatter;

    public PlayerStatsConsolePrinter(PlayerStatsFormatter playerStatsFormatter) {
        assert playerStatsFormatter != null : "playerStatsFormatter is null";
        this.playerStatsFormatter = playerStatsFormatter;
    }

    @Override
    public void print(PlayerStats playerStats) {
        System.out.println(playerStatsFormatter.format(playerStats));
    }
}
