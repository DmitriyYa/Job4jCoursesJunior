package ru.dima.collections_pro.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList<Integer> linkedList;

    @Test
    public void get() throws Exception {
        Integer i=0;
        linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        assertEquals(linkedList.get(0),i);
    }

    @Test
    public void add() throws Exception {
        linkedList = new LinkedList<>();
        Integer count=0;
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        for (Integer i : linkedList) {
            assertEquals(i,count++);
        }


    }

}