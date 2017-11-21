package ru.dima.collections_pro.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleQueueTest {
    @Test
    public void pool() throws Exception {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        Integer one = 1;
        Integer two = 2;
        assertEquals(simpleQueue.pool(), one);
        assertEquals(simpleQueue.pool(), two);

    }
}