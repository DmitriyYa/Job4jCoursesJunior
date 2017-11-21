package ru.dima.collections_pro.set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 18.11.17 21:59
 * Copyright © LLP JazzSoft
 */
public class ArraySimpleSetTest {
    @Test
    public void add() {
        ArraySimpleSet<String> stringArraySimpleSet = new ArraySimpleSet<>();
        stringArraySimpleSet.add("123");
        stringArraySimpleSet.add("456");
        stringArraySimpleSet.add("123");
        assertEquals(stringArraySimpleSet.get(0), "123");
        assertEquals(stringArraySimpleSet.get(1), "456");
        assertEquals(stringArraySimpleSet.get(2), null);

    }

}