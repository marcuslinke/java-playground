package org.example;

enum HandShape {
    SCISSORS, STONE, PAPER;

    public GameResult gameResult(HandShape opponentShape) {
        assert opponentShape != null : "opponentShape is null";

        if (this == opponentShape) {
            return GameResult.DRAW;
        }

        return switch (this) {
            case PAPER -> opponentShape == HandShape.STONE ? GameResult.WON : GameResult.LOOSE;
            case STONE -> opponentShape == HandShape.SCISSORS ? GameResult.WON : GameResult.LOOSE;
            case SCISSORS -> opponentShape == HandShape.PAPER ? GameResult.WON : GameResult.LOOSE;
        };
    }
}
