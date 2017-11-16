package ru.dima.collections_pro.list;

import java.util.Iterator;

/**
 * 5.3.1. Создать динамический список на базе массива. [#158]
 * <p>
 * Необходимо создать контейнер с методами
 * <p>
 * add(E value);
 * <p>
 * E get(int count);
 * <p>
 * и реализовать для него Iterable<E>.
 * <p>
 * Внутри контейнера должен быть массив Object[] container;
 * <p>
 * Контейнер должен быть динамический. То есть метод add(E value) - может принимать бесконечное количество элементов.
 * <p>
 * Внутри контейнера нельзя использовать структуры данных из JDK - ArrayList. LinkedList и другие.
 */
public class DynamicList<E> implements SimpleContainer<E> {

    /**
     * Внутренний массив.
     */
    private Object[] container;
    /**
     * Счетчик кол-ва элементов коллекции.
     */
    private int count=0;

    /**
     * Индекс для обхода коллекции иетратором.
     */
    private int index=0;

    /**
     * @param size размер массива
     */
    public DynamicList(int size) {
        this.container = new Object[size];
    }

    /**
     * @return размер массива
     */
    public int getSize() {
        return container.length;
    }

    /**
     * Добавить элемент в коллекцию.
     * @param value
     */
    @Override
    public boolean  add(E value) {
        if (count > container.length - 1) {
            Object[] tmp = container;
            container = new Object[container.length * 2];
            System.arraycopy(tmp, 0, container, 0, tmp.length);
        } else {
            this.container[count++] = value;
        }
        return true;
    }

    /**
     * Поличить элемент коллекции по индексу
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index >= 0 && index < container.length) {
            return (E) this.container[index];
        } else return null;
    }

    /**
     * Итератор
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return index < getSize() && container[index] != null;
            }

            @Override
            public E next() {
                return (E) container[index++];
            }
        };
        return iterator;
    }
}
