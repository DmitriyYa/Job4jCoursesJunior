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

    public static void main(String[] args) {
        int[][] v = new int[][]{{1, 2}, {3, 4, 5}, {6, 7}};
        IteratorMatrixArray iteratorMatrixArray = new IteratorMatrixArray(v);
        while (iteratorMatrixArray.hasNext()) {
            iteratorMatrixArray.next();
        }
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if (values[indexI].length - 1 <= indexJ) {
            if (values.length - 1 <= indexI) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public Object next() throws NoSuchElementException {
        int result;
//        если последний элемент внутреннего массива
        if (values[indexI].length - 1 <= indexJ) {
//            если последний элемент внешнего массива
            if (values.length - 1 <= indexI) {
                result = values[indexI][indexJ];
                System.out.println(-1);
            }
//            переходим в след внутренний массив, на первый элемент
            result = values[indexI][indexJ];
            indexI++;
            indexJ = 0;
            System.out.println(result);

//            иначе переходим на следующий элемент внутри внутреннего массива.
        } else {
            result= values[indexI][indexJ];
            indexJ++;
            System.out.println(result);
        }
        return result;
    }
}
