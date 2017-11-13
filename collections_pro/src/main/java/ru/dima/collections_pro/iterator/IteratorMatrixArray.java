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
    private int row = 0;
    private int column = 0;

    public IteratorMatrixArray(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return this.values.length > row || this.values[row].length > column;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else if (values[row].length - 1 == column) {
            return values[row++][column=0];
        }
        else {
            return values[row][column++];
        }
    }

}
