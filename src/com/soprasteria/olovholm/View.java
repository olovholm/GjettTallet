package com.soprasteria.olovholm;


import javax.xml.transform.sax.SAXSource;

/**
 * Created by olovholm on 02.02.2015.
 */
public class View {

    public final static String CURSOR = "Gjett ett nummer: >";
    public final static String WRONG_INPUT_MESSAGE = "Dette programmet kan kun forstå tall. Forsøk med et heltall, snille deg";
    public final static String NUMBER_TOO_HIGH = "Tallet du har gjettet er for høyt, vennligst prøv igjen.";
    public final static String NUMBER_TOO_LOW =  "Tallet du har gjettet er for lavt, vennligst prøv igjen.";
    public final static String NUMBER_CORRECT = "Gratulerer, du har gjettet riktig! Kan du gjenta det?";
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


    public View() {
        System.out.println(SOPRA_STERIA_ASCII_ART);
        System.out.println(INSTRUCTION_TEXT);
    }


    public void printResult(){

    }

    public void printCursor(){
        System.out.print(CURSOR);
    }

    public void printWrongInputMessage(){
        System.out.println(WRONG_INPUT_MESSAGE);

    }








}
