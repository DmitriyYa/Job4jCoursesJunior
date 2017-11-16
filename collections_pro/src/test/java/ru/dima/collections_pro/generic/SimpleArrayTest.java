package ru.dima.collections_pro.generic;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleArrayTest {
   private SimpleArray<Integer> simpleArray;

    @Test
    public void getSize() throws Exception {
        simpleArray=new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        assertEquals(simpleArray.getSize(),6);
    }

    @Test
    public void get() throws Exception {
        simpleArray=new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        assertEquals((int)simpleArray.get(1),1);
    }

    @Test
    public void delete() throws Exception {
        simpleArray=new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.delete(1);
        assertEquals(simpleArray.get(1),null);
    }

    @Test
    public void update() throws Exception {
        simpleArray=new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.update(1,2);
        assertEquals((int)simpleArray.get(1),2);
    }

}