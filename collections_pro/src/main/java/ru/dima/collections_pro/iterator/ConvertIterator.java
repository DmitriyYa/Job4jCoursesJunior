package ru.dima.collections_pro.iterator;

import java.util.*;

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
public class ConvertIterator {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new GroupIterator(its);
    }

    class GroupIterator implements Iterator {
        private final Iterator<Iterator<Integer>> iterator;
        private Iterator<Integer> currentIterator;

        public GroupIterator(Iterator<Iterator<Integer>> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            selectCurrentIterator();
            return (currentIterator != null && currentIterator.hasNext());
        }

        @Override
        public Integer next() {
            selectCurrentIterator();
            if (currentIterator == null) {
                throw new NoSuchElementException();
            }
            return currentIterator.next();
        }

        private void selectCurrentIterator() {
            if (currentIterator != null && currentIterator.hasNext()) {
                return;
            }
            currentIterator = null;
            while (iterator.hasNext()) {
                Iterator<Integer> nextIterator = iterator.next();
                if (nextIterator.hasNext()) {
                    currentIterator = nextIterator;
                    break;
                }
            }
        }
    }
}
