package ru.dima.collections_pro.set;

import java.util.Arrays;
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
    public int countElements = 0;

    /**
     * Индекс для прохождения коллекции.
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
        increaseArray();
        if (!ifThereIsSuchAndElementToReplace(e)) {
            objects[countElements++] = e;
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
        return index < countElements;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return objects[index++];
        }
        throw new NoSuchElementException();
    }

    /**
     * Если массив меньше счетчика, увеличить массив в два раза.
     */
    private void increaseArray() {
        if (countElements > objects.length - 1) {
            objects = Arrays.copyOf(objects, objects.length * 2);
        }
    }

    /**
     * если есть такой элемент заменить
     */
    private boolean ifThereIsSuchAndElementToReplace(E e) {
        boolean result = false;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null && objects[i].equals(e)) {
                objects[i] = e;
                result = true;
                break;
            }
        }
        return result;
    }
}
