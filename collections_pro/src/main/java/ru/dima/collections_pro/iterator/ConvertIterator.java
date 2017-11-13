package ru.dima.collections_pro.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Реализовать класс с методом Iterator<Integer> convert(Iterator<Iterator<Integer>> it).
 * <p>
 * Что из себя представляет запись Iterator<Iterator<Integer>?.
 * <p>
 * Каждый итератор это последовательность.
 * <p>
 * Итератор 1 – 4 2 0 4 6 4 9
 * <p>
 * Итератор 2 – 0 9 8 7 5
 * <p>
 * Итератор 3 – 1 3 5 6 7 0 9 8 4
 * <p>
 * Если мы говорим о записи Итератор Итераторов. Значит итератор содержит не конечные значения, а сложенные итераторы.
 * <p>
 * Итератор - Итератор 1, Итератор 2, Итератор 3.
 * <p>
 * Метод convert должен принимать объект итератор итератор и возвращать Итератор чисел.
 * <p>
 * Iterator<Iterator<Integer> - ((4 2 0 4 6 4 9), (0 9 8 7 5), (1 3 5 6 7 0 9 8 4))
 * <p>
 * Метод должен возвращать
 * <p>
 * Iterator<Integer> - (4 2 0 4 6 4 9 0 9 8 7 5 1 3 5 6 7 0 9 8 4)
 * <p>
 * Метод не должен копировать данные. Нужно реализовать итератор, который будет пробегать по вложенными итераторам без копирования данных.
 */
public class ConvertIterator implements Iterator {

    private final Iterator<Iterator<Integer>> values;

    public ConvertIterator(Iterator<Iterator<Integer>> values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> itertIter) {
        ArrayList<Integer> values=new ArrayList<>();

        ResultIterator resulrIterator = new ResultIterator(values);

        return resulrIterator;
    }

    private class ResultIterator implements Iterator {
        private final ArrayList<Integer> values;
        private int index = 0;

        private ResultIterator(ArrayList<Integer> values) {
            this.values = values;
        }

        @Override
        public boolean hasNext() {
            return values.size() > index;
        }

        @Override
        public Object next() {
            return values.get(index++);
        }
    }
}
