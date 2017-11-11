package ru.dima.collections_pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создать итератор возвращающий только четные цифры.
 * Итератор должен принимать список произвольных чисел.
 * <p>
 * public EvenIt(final int[] numbers) {
 * <p>
 * Iterator it = new EventIt(new int[] {4, 2, 1, 1});
 * <p>
 * методы
 * <p>
 * it.next() - возвращают только четные числа. В этом примере - это 4 и 2.
 * <p>
 * it.hasNext() - возвращает true, только если в массиве есть четные перед указателем.
 * <p>
 * Например. если мы дернем два раза метод next, то указатель сместить на второй элемент.
 * При вызове метода hasNext - он вернет false. так как после указателя больше нет четных чисел.
 */

public class IteratorEvenNumbers implements Iterator {

    /**
     * массив данных
     */
    private final int[] values;

    /**
     * счетчик
     */
    private int index = 0;

    public IteratorEvenNumbers(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < values.length; i++) {
            if (isEvenNumber(values[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        int result;
        for (int i = index; i < values.length; i++) {
            if (isEvenNumber(values[i])) {
                result = i;
                index = i + 1;
                return values[result];
            }
        }
        return new NoSuchElementException();
    }

    private boolean isEvenNumber(int i) {
        return i % 2 == 0;
    }
}
