package ru.dima.collections_pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 07.11.17 10:51
 * Copyright © LLP JazzSoft
 * <p>
 * Необходимо создать итератор для двухмерного массива.
 * <p>
 * int[][] value = {
 * {1, 2} {3, 4}
 * };
 * <p>
 * метод next = должен вернуть последовательно 1, 2, 3, 4.
 * <p>
 * Старайтесь написать универсальное решение, чтобы оно не было жестко ориентировано на тестовый пример.
 * И хотя в примере указана квадратная матрица, программа должна корректно обрабатывать и jagged array тоже.
 */
public class IteratorMatrixArray implements Iterator {

    /**
     * Массив
     */
    private final int[][] values;

    /**
     * Счетчик
     */
    private int indexI = 0;
    private int indexJ = 0;

    public IteratorMatrixArray(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;

        if (lastElementExternalArray()) {
            result = false;
        }
        return result;
    }

    @Override
    public Object next() throws NoSuchElementException {
        int result;

        if (lastElementExternalArray()) {
            result = values[indexI][indexJ];
            System.out.println("последний элемент внешнего массива - " + result);
            throw new NoSuchElementException();
        } else if (lastElementInternalArray()) {
            result = values[indexI++][indexJ];
//            indexI++;
            indexJ = 0;
            System.out.println("последний элемент внутреннего массива - " + result);
        } else {
            result = values[indexI][indexJ++];
//            indexJ++;
            System.out.println("элемент внутреннего массива - " + result);
        }
        return result;
    }


    /**
     * @return последний элемент внутреннего массива
     */
    private boolean lastElementInternalArray() {
        return values[indexI].length - 1 == indexJ;
    }


    /**
     * @return последний элемент внешнего массива
     */
    private boolean lastElementExternalArray() {
        return lastElementInternalArray() && values.length - 1 == indexI;
    }

}
