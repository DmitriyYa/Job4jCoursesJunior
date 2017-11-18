package ru.dima.collections_pro.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 5.3.2. Создать контейнер на базе связанного списка  [#159]
 * <p>
 * Необходимо создать контейнер с методами
 * <p>
 * add(E value);
 * <p>
 * E get(int index);
 * <p>
 * и реализовать для него Iterable<E>.
 * <p>
 * Внутри контейнера должен данные должны храниться через ссылки.
 * <p>
 * Контейнер должен быть динамический. То есть метод add(E value) - может принимать бесконечное количество элементов.
 * <p>
 * Внутри контейнера нельзя использовать структуры данных из JDK - ArrayList. LinkedList и другие.
 */
public class LinkedList<E> implements SimpleContainer<E> {


    /**
     * размер коллекции.
     */
    private int size;

    /**
     * Первый элемент коллекции
     */
    private Node<E> first;

    /**
     * Последний элемент коллекции.
     */
    private Node<E> last;

    /**
     * конструктор по умолчанию.
     */
    public LinkedList() {

        last = new Node<E>(first, null, null);
        first = new Node<E>(null, null, last);
    }

    /**
     * Добавить эалемент в коллекцию.
     *
     * @param e - элемент.
     * @return результат.
     */
    @Override
    public boolean add(E e) {
        addElementLast(e);
        return true;
    }

    /**
     * Получить элемент коллекции по индексу.
     *
     * @param index индекс.
     * @return элемент.
     */
    @Override
    public E get(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getElementByIndex(index);
    }

    /**
     * Итератор для прохождения коллекции.
     *
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    /**
     * Добавить элемент в конец списка.
     *
     * @param e элемент.
     */
    private void addElementLast(E e) {
        Node<E> l = last;
        l.setItem(e);
        last = new Node<>(l, null, null);
        l.next = last;
        size++;

    }

    /**
     * Вернуть элемент по индексу.
     * @param index индекс.
     * @return элемент.
     */
    private E getElementByIndex(int index) {
        Node<E> x = first;
        for (int i = 0; i <= index; i++)
            x = x.next;
        return x.item;
    }

    /**
     * @return последний элемент списка
     */
    E getElementLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    /**
     * @return первый элемент списка
     */
    E getElementFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    /**
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        void setItem(E e) {
            item = e;
        }
    }
}
