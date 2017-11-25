package ru.dima.collections_pro.set;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 18.11.17 21:59
 * Copyright © LLP JazzSoft
 */
public class ArraySimpleSetTest {
    private ArraySimpleSet<String> stringArraySimpleSet;

    @Before
    public void setUp() {
        stringArraySimpleSet = new ArraySimpleSet<>();
        stringArraySimpleSet.add("123");
        stringArraySimpleSet.add("456");
        stringArraySimpleSet.add("123");
    }

    @Test
    public void add() {
        assertEquals(stringArraySimpleSet.get(0), "123");
        assertEquals(stringArraySimpleSet.get(1), "456");
        assertEquals(stringArraySimpleSet.get(2), null);

    }

    @Test(expected = NoSuchElementException.class)
    public void ifCollectionHasReturnedNSEE() {
        stringArraySimpleSet.next();
        stringArraySimpleSet.next();
        stringArraySimpleSet.next();
    }

    @Test
    public void ifAreNoItemsInCollectionToReturnFalse() {
        stringArraySimpleSet.next();
        stringArraySimpleSet.next();
        assertFalse(stringArraySimpleSet.hasNext());
    }

    @Test
    public void returnFirstElementCollection(){
        assertEquals(stringArraySimpleSet.next(),"123");
        assertEquals(stringArraySimpleSet.next(),"456");
    }
}