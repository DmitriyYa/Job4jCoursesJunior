package ru.dima.collections_pro.set;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 1. Реализовать коллекцию Set на массиве.
 * <p>
 * Реализовать коллекцию ArraySimpleSet.
 * Коллекция должна обеспечивать void add(E e) и реализовывать Iterator<E>.
 * Коллекция не должна хранить дубликаты.
 * Set - внутри для хранения данных использует обычные массивы.
 */
public class ArraySimpleSet<E> implements Iterator {

    /**
     * массив объектов.
     */
    private Object[] objects;

    /**
     * счетчик элементов.
     */
    private int index = 0;


    /**
     * конструктор по умолчанию.
     */
    public ArraySimpleSet() {
        objects = new Object[10];
    }

    /**
     * Добавляет элементы в массив.
     * Если такой элемент есть, заменяет его.
     *
     * @param e элемент.
     */
    public void add(E e) {
        if (index > objects.length - 1) {
            Object[] tmp = objects;
            objects = new Object[objects.length * 2];
            System.arraycopy(tmp, 0, objects, 0, tmp.length);
        } else {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] != null && objects[i].equals(e)) {
                    objects[i] = e;
                    return;
                }
            }
            objects[index++] = e;
        }
    }

    /**
     * @param index
     * @return
     */
    public E get(int index) {
        return (E) objects[index];
    }


    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return objects[index++];
        }
        throw new NoSuchElementException();
    }
}
