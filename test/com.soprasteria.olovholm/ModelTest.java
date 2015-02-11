package com.soprasteria.olovholm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {
    Model m;


    @Before
    public void setUp() throws Exception {
        m = new Model();
        m.setSecretNumber(10);
    }

    @Test
    public void shenanigansShouldReturnTooHighIfNumberIsTooLow(){
        assertEquals(NumberEvaluation.TOO_HIGH, m.shenanigans(8));
    }

    @Test
    public void shenanigansShouldReturnTooLowIfNumberIsTooHigh(){
        assertEquals(NumberEvaluation.TOO_LOW, m.shenanigans(12));
    }

    @Test
    public void shenanigansShouldReturnNotValidIfNumberIsCorrect(){
        assertEquals(NumberEvaluation.NOT_VALID, m.shenanigans(10));
    }

    @Test
    public void shenanigansShouldReturnCorrectIfNumberIsOutsideThreshold(){
        assertEquals(NumberEvaluation.CORRECT_GUESS, m.shenanigans(-99));
    }

    @Test
    public void confirmCorrectNumberReturnsConfirmedCorrectIsConfirmed(){
        assertEquals(NumberEvaluation.CORRECT_GUESS_CONFIRMED, m.confirmCorrectGuess(10));
    }

    @Test
    public void confirmCorrectNumberReturnsActualValueIfSentValueIsWrongTooHigh(){
        assertEquals(NumberEvaluation.TOO_HIGH, m.confirmCorrectGuess(12));
    }

    @Test
    public void confirmCorrectNumberReturnsActualValueIfSentValueIsWrongTooLow(){
        assertEquals(NumberEvaluation.TOO_LOW, m.confirmCorrectGuess(8));
    }


    @Test
    public void listIsExpandedWithNewAttempts(){
        m.evaluateNumber(1);
        m.evaluateNumber(2);
        m.evaluateNumber(3);
        assertEquals(3,m.getNumberOfGuesses());
    }

    @Test
    public void listIsExpandedByShenanigans(){
        m.evaluateNumber(1);
        m.shenanigans(2);
        assertEquals(2,m.getNumberOfGuesses());
    }

    @Test
    public void listDoesNotAcceptTwoSimilarValuesEvaluated(){
        m.evaluateNumber(1);
        m.evaluateNumber(1);
        assertEquals(1,m.getNumberOfGuesses());
    }

    @Test
    public void listDoesNotRefuseShenanigansNumber(){
        m.evaluateNumber(2);
        m.shenanigans(15);
        assertNotEquals(NumberEvaluation.GUESSED_ALREADY, m.evaluateNumber(15));
    }

    @Test
    public void correctAfterEightTurnsShouldReturnCorrectWithModifcation(){
        m.evaluateNumber(1);
        m.evaluateNumber(2);
        m.evaluateNumber(3);
        m.evaluateNumber(4);
        m.evaluateNumber(5);
        m.evaluateNumber(6);
        m.evaluateNumber(7);
        m.evaluateNumber(8);
        assertEquals(NumberEvaluation.CORRECT_TOO_MANY_GUESSES,m.evaluateNumber(10));

    }

    @Test
    public void afterTenTurnsItsOver(){
        m.evaluateNumber(1);
        m.evaluateNumber(2);
        m.evaluateNumber(3);
        m.evaluateNumber(4);
        m.evaluateNumber(5);
        m.evaluateNumber(6);
        m.evaluateNumber(7);
        m.evaluateNumber(8);
        m.evaluateNumber(9);
        m.evaluateNumber(11);
        m.evaluateNumber(12);
        assertEquals(NumberEvaluation.TOO_MANY_GUESSES,m.evaluateNumber(12));
    }

    @Test
    public void valuesTooLowAreNotEvaluated() {
        assertEquals(NumberEvaluation.NOT_VALID,m.evaluateNumber(-999));
    }

    @Test
    public void valuesTooLowAreNotCounted() {
        m.evaluateNumber(-999);
        assertEquals(0,m.getNumberOfGuesses());
    }



}