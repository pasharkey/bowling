package com.psharkey.wbf.bowling;

/**
 * Created by sharkey on 1/3/18.
 */
public class Game {

    // private member variables
    int[] rolls;
    int score;

    /*
        Default Constructor
     */
    public Game() {
        rolls = new int[Constants.MAX_ROLLS];
        this.score = 0;
    }

    /*
        Constructor
     */
    public Game(int[] rolls) {
        this.rolls = rolls;
        this.score = 0;
    }

    /**
     *
     * @return int the current score of the game
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Setter method that will set rolls array for the game
     * @param rolls
     */
    protected void setRolls( int[] rolls ) {
        this.rolls = rolls;
    }

    /**
     * Method will calculate and set the score for the current game of bowling
     */
    public void bowl() {

        //simple validation for testing.
        //This program assumes that a valid int[] array has been provided
        assert( rolls.length > 0 );

        int currRoll = 0;

        //loop through game
        for(int i = 0; i < Constants.MAX_FRAMES; i++ ) {

            int pins = 0;

            //check for closed frames first
            if( isStrike(rolls[currRoll]) ) {

                pins = calcClosed(currRoll, rolls);
                currRoll += 1;

            }
            else if( isSpare(rolls[currRoll], rolls[currRoll+1]) ){

                pins = calcClosed(currRoll, rolls);
                currRoll += 2;

            }
            else {
                pins = rolls[currRoll] + rolls[currRoll+1];
                currRoll +=2;
            }

            updateScore(pins);  //update the score after each frame

        }
    }

    /**
     * Check if a single roll is a strike
     * @param roll
     * @return true if strike, false otherwise
     */
    private boolean isStrike(int roll) {
        return (roll == Constants.MAX_PINS) ? true : false;
    }

    /**
     * Calculates the score for a given closed frame
     * @param pos
     * @param rolls
     * @return
     */
    private int calcClosed(int pos, int[] rolls ) {
        return rolls[pos] + rolls[pos+1] + rolls[pos+2];
    }

    /**
     * Check is two rolls amount to a spare
     * @param first
     * @param second
     * @return true if spare, false otherwise
     */
    private boolean isSpare(int first, int second ) {
        return ( (first + second ) == Constants.MAX_PINS) ? true : false;
    }

    /**
     * Helper method that will update the current score of the game
     * @param pins
     */
    private void updateScore(int pins) {
        this.score += (pins);
    }


}
