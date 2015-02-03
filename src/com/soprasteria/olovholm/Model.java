package com.soprasteria.olovholm;

import java.util.*;

/**
 * Created by olovholm on 02.02.2015.
 */
public class Model {

    public final static int MAXRANGE = 100;
    public final static int MINRANGE = 0;

    private int turn;
    private int secretNumber;
    List<Integer> list;

    public Model(){
        Random random = new Random();
        secretNumber = random.nextInt((MAXRANGE - MINRANGE) + 1) + MINRANGE;
        list = new ArrayList<Integer>();
    }

    private boolean saveNumber(int number) {
        if (list.contains(number)){
            return false;
        } else {
            list.add(number);
            return true;
        }

    }



    public NumberEvaluation evaluateNumber(int number){
        if (number < MINRANGE || number > MAXRANGE){
            return NumberEvaluation.NOT_VALID;
        }
        if(!saveNumber(number)) {
            return NumberEvaluation.GUESSED_ALREADY;
        }
        if (getNumberOfGuesses() == 11) {
            return NumberEvaluation.TOO_MANY_GUESSES;
        } else if ((getNumberOfGuesses() > 7) && number == secretNumber){
            return NumberEvaluation.CORRECT_TOO_MANY_GUESSES;
        }
        if (number == secretNumber){
            return NumberEvaluation.CORRECT_GUESS;
        } else if (number < secretNumber){
            return NumberEvaluation.TOO_LOW;
        } else if (number > secretNumber){
            return NumberEvaluation.TOO_HIGH;
        } else {
            return NumberEvaluation.NOT_VALID;
        }
    }

    public int getNumberOfGuesses() {
        return list.size();
    }



}
