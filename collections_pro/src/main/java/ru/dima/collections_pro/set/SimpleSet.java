package ru.dima.collections_pro.set;

import java.util.Iterator;


/**
 * 1. Реализовать коллекцию Set на массиве.
 *
 * Реализовать коллекцию SimpleSet.
 * Коллекция должна обеспечивать void add(E e) и реализовывать Iterator<E>.
 * Коллекция не должна хранить дубликаты.
 * Set - внутри для хранения данных использует обычные массивы.
 */
public class SimpleSet<E> implements Iterator {

    /**
     * массив объектов.
     */
    private Object [] objects;

    /**
     * конструктор по умолчанию.
     */
    public SimpleSet() {
        objects=new Object[10];
    }

    /**
     * Добавляет элементы в массив.
     * Если такой элемент есть, заменяет его.
     * @param e элемент.
     */
    public void add(E e){

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
