package com.psharkey.wbf.bowling;

/**
 * Created by sharkey on 1/3/18.
 */
public class GameParser {

    /*
        Default Constructor
     */
    public GameParser() {}

    /**
     * Method will take in a valid string representing a game of bowling and convert it
     * to a corresponding integer array that represents every roll that occured during the
     * game
     *
     * @param game
     * @return int[] array of rolls
     */
    public int[] parseGameString(String game) {

        int[] rolls = new int[Constants.MAX_ROLLS]; //create a new game array
        int currRoll = 0;

        String[] frames = game.split("-");          //split up string into frames

        //loop through all the frames
        for(int i = 0; i < frames.length; i++ ) {

            String[] f = frames[i].split("");       //split the string into rolls
            int first = getFirstRoll(f);

            //check bonus frame with one roll
            if( i == Constants.MAX_FRAMES && f.length == 1 ) {
                rolls[currRoll] = first;
                currRoll += 1;
            }
            //check bonus frame with two rolls
            else if(i == Constants.MAX_FRAMES ) {
                int second = getSecondRoll(f, first);
                rolls[currRoll] = first;
                rolls[currRoll+1] = second;
                currRoll += 2;
            }
            //check for strike
            else if( (first == Constants.MAX_PINS) ) {
                rolls[currRoll] = first;
                currRoll += 1;
            }
            else {
                int second = getSecondRoll(f, first);
                rolls[currRoll] = first;
                rolls[currRoll+1] = second;
                currRoll += 2;
            }
        }

        //clean up array
        int[] clean = new int[currRoll];
        System.arraycopy( rolls, 0, clean, 0, currRoll );

        return clean;

    }

    /**
     * Helper method that will get the first roll value of a frame
     * @param frame
     * @return
     */
    private int getFirstRoll(String[] frame) {

        if(frame[0].equals(Constants.STRIKE)) {
            return Constants.MAX_PINS;
        } else {
            return Integer.valueOf(frame[0]);
        }
    }

    /**
     * Helper method that will get the second roll value of a frame
     * @param frame
     * @param first
     * @return
     */
    private int getSecondRoll(String[] frame, int first) {

        assert(frame.length == 2 );

        //check for strike
        if( frame[1].equals(Constants.STRIKE ) ) {
            return Constants.MAX_PINS;
        }

        //check for spare
        else if( frame[1].equals(Constants.SPARE) ) {
            return Math.abs(Constants.MAX_PINS - first);
        }

        else {
            return Integer.valueOf(frame[1]);
        }
    }

    /**
     * Helper method that will format and print all the rolls of a game
     * @param rolls
     */
    public String printRolls(int[] rolls) {

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for(int i = 0; i < rolls.length; i++ ) {
            sb.append(" " + rolls[i]);
        }
        sb.append(" }");
        return sb.toString();
    }




}
