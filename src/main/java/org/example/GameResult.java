package org.example;

enum GameResult {
    WON, LOOSE, DRAW;

    public static GameResult gameResultForFirstPlayer(HandShape firstPlayerShape, HandShape secondPlayerShape) {
        assert firstPlayerShape != null : "firstPlayerShape is null";
        assert secondPlayerShape != null : "secondPlayerShape is null";

        if (firstPlayerShape == secondPlayerShape) {
            return GameResult.DRAW;
        }

        return switch (firstPlayerShape) {
            case PAPER -> secondPlayerShape == HandShape.STONE ? GameResult.WON : GameResult.LOOSE;
            case STONE -> secondPlayerShape == HandShape.SCISSORS ? GameResult.WON : GameResult.LOOSE;
            case SCISSORS -> secondPlayerShape == HandShape.PAPER ? GameResult.WON : GameResult.LOOSE;
        };
    }
}
