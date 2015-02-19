package com.soprasteria.olovholm;

import java.util.*;

/**
 * Created by olovholm on 02.02.2015.
 */
public class Model {

    public final static int MAXRANGE = 100;
    public final static int MINRANGE = 0;

    private int secretNumber;
    List<Integer> list;

    public Model(){
        Random random = new Random();
        secretNumber = random.nextInt((MAXRANGE - MINRANGE) + 1) + MINRANGE;
        list = new ArrayList<Integer>();
    }

    private boolean saveNumber(int number) {
        if(number == secretNumber) {
            return false;
        }
        if (list.contains(number)){
            return false;
        } else {
            list.add(number);
            return true;
        }
    }

    public int getSecretNumber(){
        return secretNumber;
    }

    public void setSecretNumber(int number){
        secretNumber = number;
    }


    public NumberEvaluation confirmCorrectGuess(int number){
        if (number == secretNumber){
            return NumberEvaluation.CORRECT_GUESS_CONFIRMED;
        } else {
            return this.evaluateNumber(number);
        }
    }



    public NumberEvaluation evaluateNumber(int number){

        if (getNumberOfGuesses() >= 10) {
            return NumberEvaluation.TOO_MANY_GUESSES;
        } else if ((getNumberOfGuesses() >= 8) && number == secretNumber){
            return NumberEvaluation.CORRECT_TOO_MANY_GUESSES;
        } else if (number < MINRANGE || number > MAXRANGE){
            return NumberEvaluation.NOT_VALID;
        } else if (number == secretNumber) {
            return NumberEvaluation.CORRECT_GUESS;
        }

        if(!saveNumber(number)) {
            return NumberEvaluation.GUESSED_ALREADY;
        }


         if (number < secretNumber){
            return NumberEvaluation.TOO_LOW;
        } else if (number > secretNumber){
            return NumberEvaluation.TOO_HIGH;
        }
            return NumberEvaluation.NOT_VALID;

    }

    public int getNumberOfGuesses() {
        return list.size();
    }


    public NumberEvaluation shenanigans(int number) {
        saveNumber(-999);
        if (number > MAXRANGE  || number < MINRANGE ){
            return NumberEvaluation.CORRECT_GUESS;
        } else if (number < secretNumber){
            return NumberEvaluation.TOO_HIGH;
        } else if (number > secretNumber){
            return NumberEvaluation.TOO_LOW;
        } else {
            return NumberEvaluation.NOT_VALID;
        }
    }
}
