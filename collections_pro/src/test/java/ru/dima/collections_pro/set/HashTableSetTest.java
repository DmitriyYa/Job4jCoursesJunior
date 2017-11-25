package ru.dima.collections_pro.set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableSetTest {
    HashTableSet<String> hashTableSet;

    @Before
    public void setUp() {
        hashTableSet = new HashTableSet<>();
    }

    @Test
    public void add() throws Exception {
        hashTableSet.add("123");
        assertEquals(hashTableSet.iterator().next(),"123");
    }

    @Test
    public void contains() throws Exception {
        hashTableSet.add("123");
        assertTrue(hashTableSet.contains("123"));
    }

    @Test
    public void remove() throws Exception {
        hashTableSet.add("123");
        assertTrue(hashTableSet.contains("123"));
        hashTableSet.remove("123");
        assertFalse(hashTableSet.contains("123"));
    }

}