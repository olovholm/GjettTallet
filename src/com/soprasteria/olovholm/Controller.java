package com.soprasteria.olovholm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by olovholm on 02.02.2015.
 */

public class Controller {
    private View view;
    private Model model;
    private boolean exit = false;
    private Scanner keyboard;
    private static int CRAZY_ROUND = 3;

    public Controller() {
        keyboard = new Scanner(System.in);
        view = new View();
        model = new Model();
        this.loop();
    }


    //TODO skriv om teksthåndteringen her. Mer i view klassen
    public void loop() {
        while(!exit) {
            view.printCursor();
            NumberEvaluation eval = NumberEvaluation.NOT_VALID;

            if (model.getNumberOfGuesses() != CRAZY_ROUND && eval == NumberEvaluation.NOT_VALID) {
                eval = model.evaluateNumber(this.getNumber());
                view.printEval(eval);
            } else {
                eval = model.shenanigans(this.getNumber());
                view.printEval(eval);
            }


             if (eval == NumberEvaluation.CORRECT_GUESS) {
                view.printCorrectBeforeConfirmed();
                 eval = model.confirmCorrectGuess(this.getNumber());
            }


            if (eval == NumberEvaluation.TOO_MANY_GUESSES || eval == NumberEvaluation.CORRECT_TOO_MANY_GUESSES || eval == NumberEvaluation.CORRECT_GUESS_CONFIRMED) {
                exit = true;

                 if (eval == NumberEvaluation.CORRECT_TOO_MANY_GUESSES) {
                    view.printCloseButNoSigar();

                } else if (eval == NumberEvaluation.CORRECT_GUESS_CONFIRMED) {
                    view.printHurrayHurray();

                }
            }
        }
    }


    public int getNumber(){
        try {
            int myint = keyboard.nextInt();
            return myint;
        } catch (InputMismatchException e){
            keyboard.nextLine();
            view.printWrongInputMessage();
        }
        return -999;
    }

}
