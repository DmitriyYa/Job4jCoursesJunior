package ru.dima.collections_pro.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStackTest {
    @Test
    public void pool() throws Exception {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        Integer three = 3;
        Integer two = 2;
        assertEquals(simpleStack.pool(), three);
        assertEquals(simpleStack.pool(), two);
    }

}