package ru.dima.collections_pro.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 07.11.17 11:22
 * Copyright © LLP JazzSoft
 */
public class IteratorMatrixArrayTest {
    private Iterator<Integer> it;

    @Before
    public void setUp(){
        it = new IteratorMatrixArray(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }

    @Test
    public void when() {
        IteratorMatrixArray it = new IteratorMatrixArray(
                new int[][] {
                        {1},
                        {2}
                }
        );
        it.next();
        assertThat(it.hasNext(), is(true));
    }


}