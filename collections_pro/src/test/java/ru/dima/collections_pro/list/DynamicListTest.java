package ru.dima.collections_pro.list;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicListTest {
    @Test
    public void checkTheWorkWithNumbers() {
        DynamicList<Integer> dynamicList = new DynamicList<>(10);
        dynamicList.add(0);
        dynamicList.add(1);
        dynamicList.add(2);
        dynamicList.add(3);
        dynamicList.add(4);
        dynamicList.add(5);
        dynamicList.add(6);
        dynamicList.add(7);
        assertThat(dynamicList.get(3), is(3));
    }

    @Test
    public void checkTheWorkWithString() {
        DynamicList<String> dynamicList = new DynamicList<>(10);
        dynamicList.add("0");
        dynamicList.add("1");
        dynamicList.add("2");
        dynamicList.add("3");
        dynamicList.add("4");
        dynamicList.add("5");
        dynamicList.add("6");
        dynamicList.add("7");
        assertThat(dynamicList.get(3), is("3"));
    }

    @Test
    public void checkIncreaseTheArray(){
        DynamicList<Integer> dynamicList = new DynamicList<>(1);
        dynamicList.add(0);
        assertThat(dynamicList.get(0), is(0));
    }

    @Test
    public void checkGetSizeMethod(){
        DynamicList<String> dynamicList = new DynamicList<>(3);
        dynamicList.add("0");
        dynamicList.add("1");
        dynamicList.add("2");
        dynamicList.add("3");
        dynamicList.add("4");
        dynamicList.add("5");
        dynamicList.add("6");
        dynamicList.add("7");
        assertThat(dynamicList.getSize(), is(8));
    }
}