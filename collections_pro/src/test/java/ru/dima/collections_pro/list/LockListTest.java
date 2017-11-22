package ru.dima.collections_pro.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LockListTest {
    @Test
    public void hasCycle() throws Exception {
        LockList lockList=new LockList();
        LockList.Node<String> first = new LockList.Node<>("1");
        LockList.Node<String> two = new LockList.Node<>("2");
        LockList.Node<String> third = new LockList.Node<>("3");
        LockList.Node<String> four = new LockList.Node<>("4");

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = third;
        assertTrue(lockList.hasCycle(first));
    }

}