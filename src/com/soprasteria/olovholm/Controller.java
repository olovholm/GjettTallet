package com.soprasteria.olovholm;
import jdk.internal.util.xml.impl.Input;

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

    public Controller() {
        keyboard = new Scanner(System.in);
        view = new View();
        model = new Model();
        this.loop();
    }

    public void loop() {
        while(!exit){
            view.printCursor();
            NumberEvaluation eval = model.evaluateNumber(this.getNumber());
            System.out.println(eval);



            if(eval == NumberEvaluation.TOO_MANY_GUESSES || eval == NumberEvaluation.CORRECT_TOO_MANY_GUESSES) {
                exit = true;
            }

        }
    }


    public int getNumber(){
        try {
            int myint = keyboard.nextInt();
            return myint;
        } catch (InputMismatchException e){
            view.printWrongInputMessage();
        }
        return -999;
    }






}
