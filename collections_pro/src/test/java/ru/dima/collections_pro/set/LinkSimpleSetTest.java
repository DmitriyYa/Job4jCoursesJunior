package ru.dima.collections_pro.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkSimpleSetTest {
    @Test
    public void add() throws Exception {
        LinkSimpleSet<String> linkSimpleSet=new LinkSimpleSet<>();
        linkSimpleSet.add("123");
        linkSimpleSet.add("456");
        linkSimpleSet.add("789");
        linkSimpleSet.add("456");
        assertEquals(linkSimpleSet.get(0),"123");
        assertEquals(linkSimpleSet.get(1),"789");
        assertEquals(linkSimpleSet.get(2),"456");
    }

}