package com.dsalgado.examples.cleancode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chapter2 {

    /*
     *  1: Pagina 49: Nombre revelador
     */

    // Bad code
    int d; // elapsed time in days

    // Clean code
    int elapsedTimeInDays;
    int daysSinceCreation;
    int daysSincemodification;
    int fileAgeInDays;

    /*
     *  2: Pagina 49: Nombre revelador
     */

    // Bad code
    private List<int []> thelist;

    public List<int []> getItem() {
        List<int []> list1 = new ArrayList<int []>();
        for(int[] x: thelist)
            if(x[0] == 4)
                list1.add(x);
        return list1;
    }

    // Clean code
    private final int STATUS_VALUE = 0;
    private final int FLAGGED = 4;

    private List<int []> gameBoard;

    public List<int []> getFlaggedCells(){
        List<int []> flaggedCells = new ArrayList<int []>();
        for(int[] cell: gameBoard)
            if(cell[STATUS_VALUE] == FLAGGED)
                flaggedCells.add(cell);
        return flaggedCells;
    }

    // Best way
    class Cell{

        private final int STATUS_VALUE = 0;
        private final int FLAGGED = 4;

        private int[] cell;

        public boolean isFlagged(){
            return cell[STATUS_VALUE] == FLAGGED;
        }

    }

    private List<Cell> gameBoardBestWay;

    public List<Cell> getFlaggedCellsBestWay(){
        List<Cell> flaggedCells = new ArrayList<Cell>();
        for(Cell cell: gameBoardBestWay)
            if (cell.isFlagged())
                flaggedCells.add(cell);
        return flaggedCells;
    }

    /*
     *  3: Pagina 51: Desinformación
     */

    // Bad Code
    public void codeWithDisinformation(){
        int a, l, O = 1;

        if (O == 1)
            a = 01;
        else
            l = 01;

    }

    /*
     *  4: Pagina 51: Distinciones significativas
     */

    // Bad Code
    public static void copyChars(char[] a1, char[] a2){
        for(int i = 0; i < a1.length; i ++){
            a2[i] = a1[1];
        }
    }

    // Clean code
    public static void copyCharsClean(char[] source, char[] destination){
        for(int i = 0; i < source.length; i++){
            destination[i] = source[i];
        }
    }

    /*
     *  5: Pagina 53: Variables pronunciables
     */

    // Bad Code
    class DtaRcrd102{
        private Date genymdhms;
        private Date modymdhms;
        private final String pszqint = "102";
    }

    // Clean Code
    class Customer{
        private Date generationTimestamp;
        private Date modificationTimmestamp;

        private final String recordId = "102";

    }

    /*
     *  6: Pagina 54: Nombres localizables
     */

    public void nameSeachablesMethod(){

        // Bad Code
        int s = 0;
        int[] t = new int[34];

        for (int i = 0; i < 34; i ++){
            s += (t[i] * 4) / 5;
        }

        // Clean Code

        int realDaysPerIdealDay = 4;
        int WORK_DAYS_PER_WEEK = 5;
        int NUMBER_OF_TASKS = 34;

        int[] taskEstimate = new int[NUMBER_OF_TASKS];

        int sum = 0;

        for(int j = 0; j < NUMBER_OF_TASKS; j++){
            int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
            int realTaskWeeks = (realTaskDays / WORK_DAYS_PER_WEEK);
            sum += realTaskWeeks;
        }

    }

    /*
     *  7: Pagina 55: Prefijos
     */

    // Bad Code
    class Part{
        private String m_dsc; // The textual description
        void setName(String name){
            m_dsc = name;
        }
    }

    // Clean Code
    class PartClean {
        String description;
        void setDescription(String description){
            this.description = description;
        }
    }

    /*
     *  5: Pagina 59: Contexto
     */

    // Bad code
    public void printGuessStatistics(char candidate, int count){
        String number;
        String verb;
        String pluralModifier;

        if (count == 0){
            number = "no";
            verb = "are";
            pluralModifier = "s";
        }else if(count == 1){
            number = "1";
            verb = "is";
            pluralModifier = "";
        }else{
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }

        String guessMessage = String.format(
                "There %s $s%s", verb, number, candidate, pluralModifier
        );
        System.out.println(guessMessage);
    }


    // Clean Code
    class GuessStatisticsMessage{
        private String number;
        private String verb;
        private String pluralModifier;

        public String make(char candidate, int count){
            createPluralDependentMessageParts(count);
            return String.format(
                    "There %s $s%s", verb, number, candidate, pluralModifier
            );
        }

        private void createPluralDependentMessageParts(int count){
            if (count == 0){
                thereAreNoLetters();
            }else if(count == 1){
                thereIsOneLetter();
            }else{
                thereAreManyLetters(count);
            }
        }

        private void thereAreManyLetters(int count){
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }

        private void thereIsOneLetter(){
            number = "1";
            verb = "is";
            pluralModifier = "";
        }

        private void thereAreNoLetters(){
            number = "no";
            verb = "are";
            pluralModifier = "s";
        }
    }
}