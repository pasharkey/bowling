package com.psharkey.wbf.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sharkey on 1/3/18.
 */
public class GameTest {

    // private member variables
    GameParser gp;

    @Before
    public void initialize() {
        gp = new GameParser();
    }

    @Test
    public void bowlPerfect() throws Exception {

        int [] rolls = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 300);
    }

    @Test
    public void bowlPerfectSpares() throws Exception {

        int [] rolls = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 150);
    }

    @Test
    public void bowlAllOpen() throws Exception {

        int [] rolls = { 4, 5, 5, 4, 3, 6, 2, 7, 0, 9, 6, 3, 8, 1, 1, 8, 9, 0, 7, 2};

        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 90);
    }

    @Test
    public void simPerfectGameString() throws Exception {

        String strgame = "X-X-X-X-X-X-X-X-X-X-XX";
        int[] rolls = gp.parseGameString(strgame);
        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 300);
    }

    @Test
    public void simSpareGameString() throws Exception {

        String strgame = "5/-5/-5/-5/-5/-5/-5/-5/-5/-5/-5";
        int[] rolls = gp.parseGameString(strgame);
        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 150);
    }

    @Test
    public void simOpenGameString() throws Exception {

        String strgame = "45-54-36-27-09-63-81-18-90-72";
        int[] rolls = gp.parseGameString(strgame);
        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 90);
    }

    @Test
    public void simRandomGameString() throws Exception {

        String strgame = "5/-81-5/-X-6/-23-X-52-2/-X-34";
        int[] rolls = gp.parseGameString(strgame);
        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 145);
    }

    @Test
    public void simSecondRandomGameString() throws Exception {

        String strgame = "X-9/-81-X-X-X-7/-X-72-9/-9";
        int[] rolls = gp.parseGameString(strgame);
        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 191);
    }

    @Test
    public void simThirddRandomGameString() throws Exception {

        String strgame = "9/-X-9/-X-9/-X-X-9/-X-X-XX";
        int[] rolls = gp.parseGameString(strgame);
        Game g = new Game(rolls);
        assertEquals(g.getScore(), 0);
        g.bowl();
        assertEquals(g.getScore(), 229);
    }

}