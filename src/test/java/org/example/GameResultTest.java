package org.example;

import junit.framework.TestCase;

import java.lang.AssertionError;

public class GameResultTest extends TestCase {

    public void testNullCases() {

        try {
            GameResult.gameResultForFirstPlayer(null, HandShape.STONE);
            fail("Expected AssertionError");
        } catch (AssertionError e) {
            assertEquals("firstPlayerShape is null", e.getMessage());
        }

        try {
            GameResult.gameResultForFirstPlayer(HandShape.STONE, null);
            fail("Expected AssertionError");
        } catch (AssertionError e) {
            assertEquals("secondPlayerShape is null", e.getMessage());
        }

        try {
            GameResult.gameResultForFirstPlayer(null, null);
            fail("Expected AssertionError");
        } catch (AssertionError e) {
            assertEquals("firstPlayerShape is null", e.getMessage());
        }
    }

    public void testPaperVsStone() {
        assertEquals(GameResult.WON, GameResult.gameResultForFirstPlayer(HandShape.PAPER, HandShape.STONE));
    }

    public void testPaperVsScissors() {
        assertEquals(GameResult.LOOSE, GameResult.gameResultForFirstPlayer(HandShape.PAPER, HandShape.SCISSORS));
    }

    public void testStoneVsScissors() {
        assertEquals(GameResult.WON, GameResult.gameResultForFirstPlayer(HandShape.STONE, HandShape.SCISSORS));
    }

    public void testStoneVsPaper() {
        assertEquals(GameResult.LOOSE, GameResult.gameResultForFirstPlayer(HandShape.STONE, HandShape.PAPER));
    }

    public void testScissorsVsPaper() {
        assertEquals(GameResult.WON, GameResult.gameResultForFirstPlayer(HandShape.SCISSORS, HandShape.PAPER));
    }

    public void testScissorsVsStone() {
        assertEquals(GameResult.LOOSE, GameResult.gameResultForFirstPlayer(HandShape.SCISSORS, HandShape.STONE));
    }

    public void testDraw() {
        assertEquals(GameResult.DRAW, GameResult.gameResultForFirstPlayer(HandShape.PAPER, HandShape.PAPER));
        assertEquals(GameResult.DRAW, GameResult.gameResultForFirstPlayer(HandShape.STONE, HandShape.STONE));
        assertEquals(GameResult.DRAW, GameResult.gameResultForFirstPlayer(HandShape.SCISSORS, HandShape.SCISSORS));
    }
}
