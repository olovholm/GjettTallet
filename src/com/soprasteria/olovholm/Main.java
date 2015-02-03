package com.soprasteria.olovholm;

public class Main {
    Controller controller;

    public static void main(String[] args) {
        Main main = new Main();
        main.startGuessTheNumber();

    }

    public void startGuessTheNumber() {
        controller = new Controller();
    }


}
