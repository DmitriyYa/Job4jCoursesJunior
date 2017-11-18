package ru.dima.collections_pro.set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 18.11.17 21:59
 * Copyright © LLP JazzSoft
 */
public class SimpleSetTest {
    @Test
    public void add() {
        SimpleSet<String> stringSimpleSet = new SimpleSet<>();
        stringSimpleSet.add("123");
        stringSimpleSet.add("456");
        stringSimpleSet.add("123");
        assertEquals(stringSimpleSet.get(0), "123");
        assertEquals(stringSimpleSet.get(1), "456");
        assertEquals(stringSimpleSet.get(2), null);

    }

}