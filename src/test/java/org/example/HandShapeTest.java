package org.example;

import junit.framework.TestCase;

import static org.example.HandShape.*;

public class HandShapeTest extends TestCase {

    public void testNullCases() {

        try {
            SCISSORS.gameResult(null);
            fail("Expected AssertionError");
        } catch (AssertionError e) {
            assertEquals("opponentShape is null", e.getMessage());
        }

        try {
            STONE.gameResult(null);
            fail("Expected AssertionError");
        } catch (AssertionError e) {
            assertEquals("opponentShape is null", e.getMessage());
        }

        try {
            PAPER.gameResult(null);
            fail("Expected AssertionError");
        } catch (AssertionError e) {
            assertEquals("opponentShape is null", e.getMessage());
        }
    }

    public void testPaperVsStone() {
        assertEquals(GameResult.WON, PAPER.gameResult(STONE));
    }

    public void testPaperVsScissors() {
        assertEquals(GameResult.LOOSE, PAPER.gameResult(SCISSORS));
    }

    public void testStoneVsScissors() {
        assertEquals(GameResult.WON, STONE.gameResult(SCISSORS));
    }

    public void testStoneVsPaper() {
        assertEquals(GameResult.LOOSE, STONE.gameResult(HandShape.PAPER));
    }

    public void testScissorsVsPaper() {
        assertEquals(GameResult.WON, SCISSORS.gameResult(HandShape.PAPER));
    }

    public void testScissorsVsStone() {
        assertEquals(GameResult.LOOSE, SCISSORS.gameResult(STONE));
    }

    public void testDraw() {
        assertEquals(GameResult.DRAW, PAPER.gameResult(PAPER));
        assertEquals(GameResult.DRAW, STONE.gameResult(STONE));
        assertEquals(GameResult.DRAW, SCISSORS.gameResult(SCISSORS));
    }
}
