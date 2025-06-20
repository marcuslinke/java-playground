package org.example;

import java.util.Random;

public class App {

    private static int winsPlayerA = 0;
    private static int lossesPlayerA = 0;
    private static int drawsPlayerA = 0;
    private final static Random random = new Random();
    private final static int NUMBER_OF_GAMES = 100;

    public static void main(String[] args) {
        HandShape playerAShape = HandShape.PAPER;
        for (int i = 0; i < NUMBER_OF_GAMES; i++) {
            HandShape playerBShape = getRandomHandShape();
            GameResult result = GameResult.gameResultForFirstPlayer(playerAShape, playerBShape);

            switch (result) {
                case WON -> winsPlayerA++;
                case LOOSE -> lossesPlayerA++;
                case DRAW -> drawsPlayerA++;
            }
        }

        printResults();
    }

    private static HandShape getRandomHandShape() {
        return HandShape.values()[random.nextInt(HandShape.values().length)];
    }

    private static void printResults() {
        System.out.println("Player A results:");
        System.out.println("Wins: " + winsPlayerA);
        System.out.println("Losses: " + lossesPlayerA);
        System.out.println("Draws: " + drawsPlayerA);

        System.out.println("\nPlayer B results:");
        System.out.println("Wins: " + lossesPlayerA);
        System.out.println("Losses: " + winsPlayerA);
        System.out.println("Draws: " + drawsPlayerA);
    }
}
