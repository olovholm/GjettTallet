package com.soprasteria.olovholm;


/**
 * Created by olovholm on 02.02.2015.
 */
public class View {

    public final static String CURSOR = "Gjett ett nummer: >";
    public final static String TOO_MANY_TURNS = "Da har du forsøkt nok for denne gang. Start igjen for å få blanke ark og nye fargestifter";
    public final static String WRONG_INPUT_MESSAGE = "Dette programmet kan kun forstå noen. Forsøk med et heltall mellom 0 og 100, snille deg";
    public final static String NUMBER_TOO_HIGH = "Tallet du har gjettet er for høyt, vennligst prøv igjen.";
    public final static String NUMBER_TOO_LOW =  "Tallet du har gjettet er for lavt, vennligst prøv igjen.";
    public final static String NUMBER_CORRECT_CONFIRMED = "Du gjettet riktig! Well done";
    public final static String NUMBER_CORRECT = "Gratulerer, du har gjettet riktig! Kan du gjenta det? >";
    public final static String NUMBER_CORRECT_TOO_MANY_TURNS = "Du fant riktig tall, men har brukt mer enn 7 forsøk. Prøv igjen og se om du kan forbedre deg.";
    public final static String NUMBER_GUESSED_BEFORE = "Du har gjettet dette tallet før, og vet dermed at det ikke er riktig. Du vil ikke miste et forsøk på dette.";
    public final static String INSTRUCTION_TEXT = "Velkommen til \"Gjett tallet\". Målet med leken er å gjette et tilfeldig valgt tall mellom 1 og 100 på 7 eller færre forsøk, lykketreff teller ikke, så du må kunne gjenta det for alle tall.\n" +
            "Du vil etter hvert forsøk få beskjed om du har gjetter for høye eller for lavt. Lykke til.";
    public final static String SOPRA_STERIA_ASCII_ART = "    _                                 _                    _       \n" +
            "   | |                               | |   _              (_)      \n" +
            "    \\ \\   ___  ____   ____ ____       \\ \\ | |_  ____  ____ _  ____ \n" +
            "     \\ \\ / _ \\|  _ \\ / ___) _  |       \\ \\|  _)/ _  )/ ___) |/ _  |\n" +
            " _____) ) |_| | | | | |  ( ( | |   _____) ) |_( (/ /| |   | ( ( | |\n" +
            "(______/ \\___/| ||_/|_|   \\_||_|  (______/ \\___)____)_|   |_|\\_||_|\n" +
            "              |_|                                                  \n\n\n";
    public final static String YOU_ROCK = "" +
            " ,ggg,         gg                           ,ggggggggggg,                                    \n" +
            "dP\"\"Y8a        88                          dP\"\"\"88\"\"\"\"\"\"Y8,                       ,dPYb,     \n" +
            "Yb, `88        88                          Yb,  88      `8b                       IP'`Yb     \n" +
            " `\"  88        88                           `\"  88      ,8P                       I8  8I     \n" +
            "     88        88                               88aaaad8P\"                        I8  8bgg,  \n" +
            "     88        88    ,ggggg,   gg      gg       88\"\"\"\"Yb,      ,ggggg,    ,gggg,  I8 dP\" \"8  \n" +
            "     88       ,88   dP\"  \"Y8gggI8      8I       88     \"8b    dP\"  \"Y8gggdP\"  \"Yb I8d8bggP\"  \n" +
            "     Y8b,___,d888  i8'    ,8I  I8,    ,8I       88      `8i  i8'    ,8I i8'       I8P' \"Yb,  \n" +
            "      \"Y88888P\"88,,d8,   ,d8' ,d8b,  ,d8b,      88       Yb,,d8,   ,d8',d8,_    _,d8    `Yb, \n" +
            "           ,ad8888P\"Y8888P\"   8P'\"Y88P\"`Y8      88        Y8P\"Y8888P\"  P\"\"Y8888PP88P      Y8 \n" +
            "          d8P\" 88                                                                            \n" +
            "        ,d8'   88                                                                            \n" +
            "        d8'    88                                                                            \n" +
            "        88     88                                                                            \n" +
            "        Y8,_ _,88                                                                            \n" +
            "         \"Y888P\"                                                                             ";

    public View() {
        System.out.println(SOPRA_STERIA_ASCII_ART);
        System.out.println(INSTRUCTION_TEXT);
    }



    public void printCursor(){
        System.out.print(CURSOR);
    }



    public void printEval(NumberEvaluation eval) {
        if (eval == NumberEvaluation.TOO_HIGH) {
            System.out.println(NUMBER_TOO_HIGH);
        } else if (eval == NumberEvaluation.TOO_LOW){
            System.out.println(NUMBER_TOO_LOW);
        } else if (eval == NumberEvaluation.GUESSED_ALREADY){
            System.out.println(NUMBER_GUESSED_BEFORE);
        } else if (eval == NumberEvaluation.TOO_MANY_GUESSES){
            System.out.println(TOO_MANY_TURNS);
        } else if (eval == NumberEvaluation.CORRECT_TOO_MANY_GUESSES) {
            System.out.println(NUMBER_CORRECT_TOO_MANY_TURNS);
        } else if (eval == NumberEvaluation.CORRECT_GUESS_CONFIRMED) {
            System.out.println(NUMBER_CORRECT_CONFIRMED);
            System.out.println(YOU_ROCK);
        } else if (eval == NumberEvaluation.NOT_VALID) {
            System.out.println(WRONG_INPUT_MESSAGE);
        } else if (eval == NumberEvaluation.CORRECT_GUESS) {
            System.out.println(NUMBER_CORRECT);
        } else {
            System.out.print("This text should be handled");
            System.out.println(eval);
        }

    }



}
