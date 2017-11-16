package ru.dima.collections_pro.list;

import java.util.Iterator;


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
    Node<E> first;

    /**
     * Последний элемент коллекции.
     */
    Node<E> last;

    /**
     * конструктор по умолчанию.
     */
    public LinkedList() {
        this.size = 10;
    }

    /**
     * Добавить эалемент в коллекцию.
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * Получить элемент коллекции по индексу.
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return node(index).item;
    }

    /**
     * Итератор для прохождения коллекции.
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            @Override
            public boolean hasNext() {

                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
        return iterator;
    }

    /**
     * @param e
     */
    private void linkLast(E e) {
        final Node<E> l = last; // l присваиваем последний элемент коллекции
        final Node<E> newNode = new Node<>(l, e, null); // создаем новый элеменит, с указанием предшествующего.
        last = newNode; //последнему элементу коллекции присваиваем созданный элемент.
        if (l == null)// еслиследующего элемента нет, значит нет вообще элементов
            first = newNode; // создаем первый элемент
        else
            l.next = newNode; //текущеу элементу присваиваем ссылку на следующий
        size++;

    }

    /**
     * @param index
     * @return
     */
    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
