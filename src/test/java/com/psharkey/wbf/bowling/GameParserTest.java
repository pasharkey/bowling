package com.psharkey.wbf.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sharkey on 1/3/18.
 */
public class GameParserTest {

    // private member variables
    GameParser gp;

    @Before
    public void initialize() {
        gp = new GameParser();
    }

    @Test
    public void parsePerfectGameString() throws Exception {

        String g = "X-X-X-X-X-X-X-X-X-X-XX";
        String r = "{ 10 10 10 10 10 10 10 10 10 10 10 10 }";
        int[] rolls = gp.parseGameString(g);
        assertTrue(r.equals(gp.printRolls(rolls)));
    }

    @Test
    public void parseSpareGameString() throws Exception {

        String g = "5/-5/-5/-5/-5/-5/-5/-5/-5/-5/-5";
        String r = "{ 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 }";
        int[] rolls = gp.parseGameString(g);
        assertTrue(r.equals(gp.printRolls(rolls)));
    }

    @Test
    public void parseOpenGameString() throws Exception {

        String g = "45-54-36-27-09-63-81-18-90-72";
        String r = "{ 4 5 5 4 3 6 2 7 0 9 6 3 8 1 1 8 9 0 7 2 }";
        int[] rolls = gp.parseGameString(g);
        assertTrue(r.equals(gp.printRolls(rolls)));
    }

    @Test
    public void parsRandomGameString() throws Exception {

        String g = "5/-81-5/-X-6/-23-X-52-2/-X-34";
        String r = "{ 5 5 8 1 5 5 10 6 4 2 3 10 5 2 2 8 10 3 4 }";
        int[] rolls = gp.parseGameString(g);
        assertTrue(r.equals(gp.printRolls(rolls)));
    }

    @Test
    public void parsSecondRandomGameString() throws Exception {

        String g = "X-9/-81-X-X-X-7/-X-72-9/-9";
        String r = "{ 10 9 1 8 1 10 10 10 7 3 10 7 2 9 1 9 }";
        int[] rolls = gp.parseGameString(g);
        assertTrue(r.equals(gp.printRolls(rolls)));
    }

    @Test
    public void parsThirdRandomGameString() throws Exception {

        String g = "X-9/-81-X-X-X-7/-X-72-9/-9";
        String r = "{ 10 9 1 8 1 10 10 10 7 3 10 7 2 9 1 9 }";
        int[] rolls = gp.parseGameString(g);
        assertTrue(r.equals(gp.printRolls(rolls)));
    }

}