package ru.dima.collections_pro.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList<String> linkedList;

    @Test
    public void add() throws Exception {
        linkedList = new LinkedList<>();
        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("2");
        assertEquals(linkedList.get(2),"2");
    }

//    @Test
//    public void nextNode() throws Exception {
//        linkedList = new LinkedList<>();
//        linkedList.add("0");
//        linkedList.add("1");
//        linkedList.add("2");
//        assertEquals(linkedList.nextNode(1),);
//    }

}