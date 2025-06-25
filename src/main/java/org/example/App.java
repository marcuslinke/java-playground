package org.example;

import java.util.Random;

public class App {

    private final static Random random = new Random();
    private final static int NUMBER_OF_GAMES = 100;
    private final static PlayerStatsPrinter printer = new PlayerStatsConsolePrinter(new PlayerStatsFormatter());

    public static void main(String[] args) {
        PlayerStats playerAStats = new PlayerStats("Player A");
        PlayerStats playerBStats = new PlayerStats("Player B");

        HandShape playerAShape = HandShape.PAPER;

        for (int i = 0; i < NUMBER_OF_GAMES; i++) {
            HandShape playerBShape = getRandomHandShape();
            GameResult gameResultPlayerA = playerAShape.gameResult(playerBShape);

            switch (gameResultPlayerA) {
                case WON -> {
                    playerAStats.wins++;
                    playerBStats.losses++;
                }
                case LOOSE -> {
                    playerAStats.losses++;
                    playerBStats.wins++;
                }
                case DRAW -> {
                    playerAStats.draws++;
                    playerBStats.draws++;
                }
            }
        }

        printer.print(playerAStats);
        printer.print(playerBStats);
    }

    private static HandShape getRandomHandShape() {
        return HandShape.values()[random.nextInt(HandShape.values().length)];
    }

}
